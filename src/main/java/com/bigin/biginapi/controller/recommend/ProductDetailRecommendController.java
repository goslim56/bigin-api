package com.bigin.biginapi.controller.recommend;

import com.bigin.biginapi.domain.product.Product;
import com.bigin.biginapi.request.BasicRequestBody;
import com.bigin.biginapi.service.Analysis;
import com.bigin.biginapi.validator.RequestBodyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Optional;
//import org.springframework.hateoas.mvc.C

@Controller
@RequiredArgsConstructor
public class ProductDetailRecommendController {
    private final RequestBodyValidator productDetailRequestBodyValidator;
    private final Analysis productDetailAnalysis;

    @PostMapping("/recommend/product_detail")
    @ResponseBody
    public Product recommendProductDetailPage(@RequestBody @Valid BasicRequestBody requestBody) {
        if (!productDetailRequestBodyValidator.validate(requestBody)) {
            return null;
        }
        Optional<Product> analysisResult = productDetailAnalysis.analysis();
        return analysisResult.orElse(null);
    }
}