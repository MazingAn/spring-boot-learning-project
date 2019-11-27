package com.amz.learn.jpa.repository;

import java.util.List;

import com.amz.learn.jpa.beans.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstName(String firstName);
    Customer findById(long id);

}
