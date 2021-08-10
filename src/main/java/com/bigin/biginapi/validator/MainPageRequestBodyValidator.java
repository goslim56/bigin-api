package com.bigin.biginapi.validator;

import com.bigin.biginapi.request.BasicRequestBody;
import org.springframework.stereotype.Component;

@Component
public class MainPageRequestBodyValidator implements  RequestBodyValidator{
    @Override
    public Boolean validate(BasicRequestBody requestBody) {
        return requestBody.getUuid() != null && requestBody.getKeyword() != null;
    }
}
