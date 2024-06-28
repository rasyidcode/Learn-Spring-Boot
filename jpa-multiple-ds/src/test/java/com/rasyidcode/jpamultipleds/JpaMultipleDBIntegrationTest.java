package com.rasyidcode.jpamultipleds;

import com.rasyidcode.jpamultipleds.product.Product;
import com.rasyidcode.jpamultipleds.product.ProductRepository;
import com.rasyidcode.jpamultipleds.user.User;
import com.rasyidcode.jpamultipleds.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableTransactionManagement
public class JpaMultipleDBIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("userTransactionManager")
    public void whenCreatingUser_thenCreated() {
        User user = new User("John", "john@test.com", 20);
        user = userRepository.save(user);

        assertNotNull(userRepository.findOne(Example.of(user)));
    }

    @Test
    @Transactional("userTransactionManager")
    public void whenCreatingUserWithSameEmail_thenRollback() {
        User user = new User("John", "john.doe@example.com", 39);
        User savedUser = userRepository.save(user);
        assertNotNull(userRepository.findOne(Example.of(savedUser)));

        User user2 = new User("Doe", "john.doe@example.com", 31);
        assertThrows(DataIntegrityViolationException.class, () -> userRepository.save(user2));
    }

    @Test
    @Transactional("productTransactionManager")
    public void whenCreatingProduct_thenCreated() {
        Product product = new Product("Jordan", 399.0);
        Product savedProduct = productRepository.save(product);
        assertNotNull(productRepository.findOne(Example.of(savedProduct)));
    }

}
