package dev.cryss.productrating.controllers;

import dev.cryss.productrating.domain.product.Product;
import dev.cryss.productrating.services.ProductService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {

      var productSaved = productService.save (product);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/product/{id}")
                .buildAndExpand(productSaved.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(product, headers, HttpStatus.CREATED);
    }
}
