package com.bigin.biginapi.controller.recommend;

import com.bigin.biginapi.request.BasicRequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RecommendControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void 메인페이지_상품_추천_키워드() throws Exception {
        BasicRequestBody basicRequestBody = BasicRequestBody.builder()
                .uuid("1234")
                .productCodes(new String[]{"1","2","3","4"})
                .keyword(new String[]{"청바지", "반바지", "pk티셔츠"})
                .cartProductCodes(new String[]{"1"})
                .purchasedProductCodes(new String[]{"1","2","3","4"})
                .build();

        mockMvc.perform(post("/recommend/main")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(basicRequestBody)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void 메인페이지_상품_추천_키워드_X() throws Exception {
        BasicRequestBody basicRequestBody = BasicRequestBody.builder()
                .uuid("1234")
                .productCodes(new String[]{"1","2","3","4"})
                .cartProductCodes(new String[]{"1"})
                .purchasedProductCodes(new String[]{"1","2","3","4"})
                .build();

        mockMvc.perform(post("/recommend/main")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(basicRequestBody)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
        ;
    }


    @Test
    public void 상품_상세_페이지_추천() throws Exception {
        BasicRequestBody basicRequestBody = BasicRequestBody.builder()
                .uuid("1234")
                .productCodes(new String[]{"1","2","3","4"})
                .keyword(new String[]{"청바지", "반바지", "pk티셔츠"})
                .cartProductCodes(new String[]{"1"})
                .purchasedProductCodes(new String[]{"1","2","3","4"})
                .build();

        mockMvc.perform(post("/recommend/product_detail")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(basicRequestBody)))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void 장바구니_추천() throws Exception {
        BasicRequestBody basicRequestBody = BasicRequestBody.builder()
                .uuid("1234")
                .productCodes(new String[]{"1","2","3","4"})
                .keyword(new String[]{"청바지", "반바지", "pk티셔츠"})
                .cartProductCodes(new String[]{"1"})
                .purchasedProductCodes(new String[]{"1","2","3","4"})
                .build();

        mockMvc.perform(post("/recommend/cart")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(basicRequestBody)))
                .andDo(print())
                .andExpect(status().isOk());
    }

}