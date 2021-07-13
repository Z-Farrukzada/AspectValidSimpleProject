package com.validationModule.validationModule.aspect;

import com.google.gson.Gson;
import com.validationModule.validationModule.model.ResponseModel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
@Component
@Aspect
public class ValidationAspect {

    private static final Logger log = LoggerFactory.getLogger(ValidationAspect.class);

    @Before("@annotation(com.validationModule.validationModule.annotation.CheckValidate)")
    public void checkValidateCall(JoinPoint joinPoint) throws Exception {
        log.info("Http Request " + joinPoint.getArgs()[0]);
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            if (args[1] instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) args[1];
                ResponseModel error = this.validateRequestParams(bindingResult);
                if (error != null) {
                    ServletRequestAttributes res = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                    HttpServletResponse response = res.getResponse();
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                    response.setStatus(HttpStatus.BAD_REQUEST.value());

                    OutputStream output = null;
                    try {
                        output = response.getOutputStream();
                        String errorGson = new Gson().toJson(error);
                        log.info("aop detected parameter irregularity" + errorGson);
                        output.write(errorGson.getBytes("UTF-8"));
                    } catch (IOException e) {
                        log.error(e.getMessage());
                    } finally {
                        try {
                            if (output != null) {
                                output.close();
                            }
                        } catch (IOException e) {
                            log.error(e.getMessage());
                        }
                    }
                }
            }
        }
    }

    private ResponseModel validateRequestParams(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            List<String> lists = new ArrayList<>();
            for (ObjectError objectError : objectErrors) {
                lists.add(objectError.getDefaultMessage());
            }
            return new ResponseModel(HttpStatus.BAD_REQUEST.value(), "empty", lists);
        }
        return null;
    }


}
