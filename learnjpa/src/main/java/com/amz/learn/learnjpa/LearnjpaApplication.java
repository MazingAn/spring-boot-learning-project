package com.amz.learn.learnjpa;

import com.amz.learn.learnjpa.beans.Customer;
import com.amz.learn.learnjpa.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LearnjpaApplication {

    private static final Logger log = (Logger) LoggerFactory.getLogger(LearnjpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LearnjpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            //add few customers
            repository.save(new Customer("Jack", "Bruce"));
            repository.save(new Customer("Tom", "Bruce"));
            repository.save(new Customer("Tom", "Clu"));
            repository.save(new Customer("Jim", "Green"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch one individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bruce").forEach(bruce ->{
                log.info(bruce.toString());
            });
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByFirstName('Tom'):");
            log.info("--------------------------------------------");
            repository.findByFirstName("Tom").forEach(tom ->{
                log.info(tom.toString());
            });
            log.info("");
        };
    }

}
