package dev.cryss.productrating.services;

import dev.cryss.productrating.controllers.exceptions.ProductServiceCustomException;
import dev.cryss.productrating.domain.product.Product;
import dev.cryss.productrating.domain.product.ProductRating;
import dev.cryss.productrating.domain.product.ProductRatingKey;
import dev.cryss.productrating.repositories.ProductRatingRepository;
import dev.cryss.productrating.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ProductRatingService {
    private final ProductRatingRepository productRatingRepository;


    public Iterable<ProductRating> getAllProductRatings() {
        return productRatingRepository.findAll();
    }


    public ProductRating getProductRating(ProductRatingKey id) {
        return (ProductRating) productRatingRepository
                .findById (id)
                .orElseThrow(() -> new RuntimeException ("Error"));
    }


    public ProductRating save(ProductRating ProductRating) {
        return productRatingRepository.save(ProductRating);
    }
}
