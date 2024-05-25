package com.rasyidcode.springcontext2.services;

import com.rasyidcode.springcontext2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDeliveryService {

    @Autowired
    private ProductRepository productRepository;

    public void addSomeProducts() {
        productRepository.add();
        productRepository.add();
        productRepository.add();
    }

}
