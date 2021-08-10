package com.bigin.biginapi;

import com.bigin.biginapi.domain.product.Product;
import com.bigin.biginapi.domain.product.ProductType;
import com.bigin.biginapi.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BiginApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiginApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ApplicationRunner applicationRunner(ProductRepository productRepository) {
		return args -> {
			Product product = Product.builder()
					.advertiserId("1")
					.discount(12L)
					.price(123L)
					.productCode("P00000J")
					.productName("생플상품")
					.productType(ProductType.BAG)
					.build();

			Product product1 = Product.builder()
					.advertiserId("2")
					.discount(500L)
					.price(10000L)
					.productCode("P00000J")
					.productName("생플상품1")
					.productType(ProductType.ETC)
					.build();


			Product product2 = Product.builder()
					.advertiserId("3")
					.discount(1000L)
					.price(20000L)
					.productCode("P00000L")
					.productName("생플상품2")
					.productType(ProductType.SHIRT)
					.build();

			productRepository.save(product);
			productRepository.save(product1);
			productRepository.save(product2);
		};
	}
}
