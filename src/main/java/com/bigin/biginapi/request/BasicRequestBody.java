package com.bigin.biginapi.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasicRequestBody {

    @NotEmpty
    private String uuid;
    private String[] productCodes;
    private String[] keyword;
    private String[] cartProductCodes;
    private String[] purchasedProductCodes;
}
