package dev.cryss.productrating.domain.product;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;

    @OneToMany
    @JoinColumns ({
            @JoinColumn(
                    name="customer_id",
                    referencedColumnName = "id"
            )
    })
    private Set<ProductRating> ratings;

}
