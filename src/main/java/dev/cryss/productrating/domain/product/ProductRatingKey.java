package dev.cryss.productrating.domain.product;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data //generates equals(), toString() and hashCode() methods for us.
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ProductRatingKey implements Serializable {

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;


}
