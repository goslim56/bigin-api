package com.bigin.biginapi.validator;

import com.bigin.biginapi.request.BasicRequestBody;

public interface RequestBodyValidator {
    Boolean validate(BasicRequestBody requestBody);
}
