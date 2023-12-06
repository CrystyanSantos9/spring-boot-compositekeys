package dev.cryss.productrating.repositories;

import dev.cryss.productrating.domain.product.Product;
//import dev.cryss.productrating.domain.product.ProductRating;
//import dev.cryss.productrating.domain.product.ProductRatingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
