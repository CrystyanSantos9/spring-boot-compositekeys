package dev.cryss.productrating.repositories;

import dev.cryss.productrating.domain.product.ProductRating;
import dev.cryss.productrating.domain.product.ProductRatingKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRatingRepository extends JpaRepository<ProductRating, ProductRatingKey> {

}
