package dev.cryss.productrating.services;

import dev.cryss.productrating.controllers.exceptions.CustomServiceCustomException;
import dev.cryss.productrating.controllers.exceptions.ProductServiceCustomException;
import dev.cryss.productrating.domain.product.Customer;
import dev.cryss.productrating.domain.product.Product;
import dev.cryss.productrating.repositories.CustomerRepository;
import dev.cryss.productrating.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


    public Customer getCustomer(long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomServiceCustomException ("Customer with given Id not found","CUSTOMER_NOT_FOUND"));
    }


    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
