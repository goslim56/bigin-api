package com.bigin.biginapi.domain.product;


import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String advertiserId;
    private String productCode;
    private String productName;
    @Enumerated(EnumType.STRING)
    private ProductType productType = ProductType.ETC;
    private Long price;
    private Long discount;
}
