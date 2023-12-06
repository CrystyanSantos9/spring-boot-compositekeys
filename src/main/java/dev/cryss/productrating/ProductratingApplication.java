package dev.cryss.productrating;

import dev.cryss.productrating.domain.product.Customer;
import dev.cryss.productrating.domain.product.Product;
//import dev.cryss.productrating.domain.product.ProductRating;
//import dev.cryss.productrating.domain.product.ProductRatingKey;
import dev.cryss.productrating.services.CustomerService;
import dev.cryss.productrating.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ProductratingApplication {

	public static void main(String[] args) {
		SpringApplication.run (ProductratingApplication.class, args);

	}

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Product(1L, "TV", 2500.00D, "htpp://urlimage", null));
			productService.save(new Product(2L, "TV2", 2500.00D, "htpp://urlimage", null));
			productService.save(new Product(3L, "TV3", 2500.00D, "htpp://urlimage", null));
//			customerService.save(new Customer (1L, "Alexandre", null));
			// more products
		};
	}

	@Bean
	CommandLineRunner runnerL(CustomerService customerService) {
		return args -> {

			customerService.save(new Customer (1L, "Alexandre", null));
			// more products
		};
	}

}
