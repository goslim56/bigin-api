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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import org.springframework.hateoas.mvc.C

@Controller
@RequiredArgsConstructor
public class MainRecommendController {
    private final RequestBodyValidator mainPageRequestBodyValidator;
    private final Analysis morphemeAnalysis;

    @PostMapping("/recommend/main")
    @ResponseBody
    public Product recommendMainPage(@RequestBody @Valid BasicRequestBody requestBody) {
        if (!mainPageRequestBodyValidator.validate(requestBody)) {
            return null;
        }
        Optional<Product> analysisResult = morphemeAnalysis.analysis();
        return analysisResult.orElse(null);
    }
}