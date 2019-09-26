package com.palex.Rest;

import com.palex.Rest.view.ResultView;
import com.palex.Rest.view.SuccessView;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResultDataAdvice implements ResponseBodyAdvice {

    /**
     * Определить поддерживается ли кастомизация.
     * @param methodParameter метод.
     * @param aClass класс конвертера.
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !methodParameter.hasMethodAnnotation((ExceptionHandler.class));
    }

    /**
     * Кастомизация ответа сервера.
     * @param o                  Данные.
     * @param methodParameter    метод.
     * @param mediaType          тип данных.
     * @param aClass             класс конвертера.
     * @param serverHttpRequest  запрос.
     * @param serverHttpResponse ответ.
     * @return объект отображения.
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getParameterType().getName().equals("void")) {
            return new SuccessView();
        } else {
            return new ResultView(o);
        }
    }
}
