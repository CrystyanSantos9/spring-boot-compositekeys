package dev.cryss.productrating.controllers;

import dev.cryss.productrating.domain.product.Customer;
import dev.cryss.productrating.domain.product.ProductRating;
import dev.cryss.productrating.services.CustomerService;
import dev.cryss.productrating.services.ProductRatingService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/ratings")
@AllArgsConstructor
public class ProductRatingController {
    private final ProductRatingService productRatingService;

    @GetMapping
    public @NotNull Iterable<ProductRating> getAllProductRatings() {
        return productRatingService.getAllProductRatings ();
    }

    @PostMapping
    public ResponseEntity<ProductRating> create(@RequestBody ProductRating productRating) {

      var productRatingSaved = productRatingService.save (productRating);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/ratings/{id}")
                .buildAndExpand(productRatingSaved.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(productRating, headers, HttpStatus.CREATED);
    }
}
