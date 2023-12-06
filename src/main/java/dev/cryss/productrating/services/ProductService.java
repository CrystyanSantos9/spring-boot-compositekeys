package dev.cryss.productrating.services;

import dev.cryss.productrating.controllers.exceptions.ProductServiceCustomException;
import dev.cryss.productrating.controllers.exceptions.RestResponseEntityExceptionHandler;
import dev.cryss.productrating.domain.product.Product;
import dev.cryss.productrating.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getProduct(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ProductServiceCustomException("Product with given Id not found","PRODUCT_NOT_FOUND"));
    }


    public Product save(Product product) {
        return productRepository.save(product);
    }
}
