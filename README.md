[![N|Solid](https://bigin.io/assets/mobile/m_header_symbol.svg)](https://bigin.io/main)
- # 김경한 bigin api 과제



- ### 개발 환경
    |구분|제품명|Version|
    |------|---|---|
    |개발언어|Java|11|
    |Framework|SpringBoot|2.5.3|
    |데이터베이스|H2|1.4.200|

- ### 테스트 방법
1. POST /recommend/cart
    - 장바구니 페이지에서 해당 상품과 유사도가 높은 상품 정보 호출
    - Request Sample
        ```
         {
        	"uuid" : "1123",
        	"productCodes": ["1","2","3","4"],
        	"keyword": ["청바지", "반바지", "pk티셔츠"],
        	"cartProductCodes": ["1"],
        	"purchasedProductCodes":  ["1","2","3","4"]
        }
        ```
        
    - response Sample
        ```
       {
            "id": 1,
            "advertiserId": "1",
            "productCode": "P00000J",
            "productName": "생플상품",
            "productType": "BAG",
            "price": 123,
            "discount": 12
        }
        ```
2. POST /recommend/main
    - 쇼핑몰 메인 페이지에서 사용자가 검색한 키워드가 있다면 형태소 분석을 통하여 가장 유사
한 상품 정보 호출
    - Request Sample
        ```
        {
        	"uuid" : "1123",
        	"productCodes": ["1","2","3","4"],
        	"keyword": ["청바지", "반바지", "pk티셔츠"],
        	"cartProductCodes": ["1","2","3","4"],
        	"purchasedProductCodes":  ["1","2","3","4"]
        }
        ```
        
    - response Sample
        ```
        {
            "id": 2,
            "advertiserId": "2",
            "productCode": "P00000J",
            "productName": "생플상품1",
            "productType": "ETC",
            "price": 10000,
            "discount": 500
        }
        ```
3. POST /recommend/product_detail
    - 상품 상세 페이지에서 해당 상품과 유사도가 높은 상품 호출
    - Request Sample
        ```
        {
        	"uuid" : "1123",
        	"productCodes": ["1","2","3","4"],
        	"keyword": ["청바지", "반바지", "pk티셔츠"],
        	"cartProductCodes": ["1","2","3","4"],
        	"purchasedProductCodes":  ["1","2","3","4"]
        }
        ```
        
    - response Sample
        ```
        {
            "id": 3,
            "advertiserId": "3",
            "productCode": "P00000L",
            "productName": "생플상품2",
            "productType": "SHIRT",
            "price": 20000,
            "discount": 1000
        }
        ```




- ### 클래스 다이어그램
[![N|Solid](https://i.ibb.co/py1B5Vm/image.png)](https://i.ibb.co/py1B5Vm/image.png)