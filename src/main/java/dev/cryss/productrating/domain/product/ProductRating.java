package dev.cryss.productrating.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_ratings")
public class ProductRating {

    //Composition key
    @EmbeddedId
    private ProductRatingKey id;

    private Integer rating;
}
