package com.bigin.biginapi.controller.recommend;

import com.bigin.biginapi.domain.product.Product;
import com.bigin.biginapi.request.BasicRequestBody;
import com.bigin.biginapi.service.Analysis;
import com.bigin.biginapi.validator.RequestBodyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Optional;
//import org.springframework.hateoas.mvc.C

@Controller
@RequiredArgsConstructor
public class CartRecommendController {
    private final RequestBodyValidator cartRequestBodyValidator;
    private final Analysis cartAnalysis;

    @PostMapping("/recommend/cart")
    @ResponseBody
    public Product recommendProductDetailPage(@RequestBody @Valid BasicRequestBody requestBody) {
        if (!cartRequestBodyValidator.validate(requestBody)) {
            return null;
        }
        Optional<Product> analysisResult = cartAnalysis.analysis();
        return analysisResult.orElse(null);
    }
}