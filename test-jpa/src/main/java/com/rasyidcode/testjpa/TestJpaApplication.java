package com.rasyidcode.testjpa;

import com.rasyidcode.product.model.Product;
import com.rasyidcode.product.repository.ProductRepository;
import com.rasyidcode.testjpa.customer.Customer;
import com.rasyidcode.testjpa.customer.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {
        "com.rasyidcode.product.repository",
        "com.rasyidcode.testjpa.customer"
})
@EntityScan({
        "com.rasyidcode.product.model",
        "com.rasyidcode.testjpa.customer"
})
@SpringBootApplication
public class TestJpaApplication {

    private static final Logger logger = LoggerFactory.getLogger(TestJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TestJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            Customer customer = new Customer("John Doe", "johndoe@gmail.com", "California, United Stated");
            customerRepository.save(customer);
            logger.info("Customer created!");
        };
    }

    @Bean
    public CommandLineRunner commandLineRunner2(ProductRepository productRepository) {
        return args -> {
            Product product = new Product("Cool Watch", "Watch");
            productRepository.save(product);
            logger.info("Product created!");
        };
    }
}
