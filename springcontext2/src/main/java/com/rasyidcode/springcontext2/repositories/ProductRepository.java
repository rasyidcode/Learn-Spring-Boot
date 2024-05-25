package com.rasyidcode.springcontext2.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    public void add() {
        System.out.println("product was added");
    }

}
