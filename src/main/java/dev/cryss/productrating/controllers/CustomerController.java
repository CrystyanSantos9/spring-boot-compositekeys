package dev.cryss.productrating.controllers;

import dev.cryss.productrating.domain.product.Customer;
import dev.cryss.productrating.domain.product.Product;
import dev.cryss.productrating.services.CustomerService;
import dev.cryss.productrating.services.ProductService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/costumers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public @NotNull Iterable<Customer> getAllCustomers() {
        return customerService.getAllCustomers ();
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {

      var customerSaved = customerService.save (customer);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/costumer/{id}")
                .buildAndExpand(customerSaved.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }
}
