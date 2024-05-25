package com.rasyidcode.springcontext2;

import com.rasyidcode.springcontext2.config.AppConfig;
import com.rasyidcode.springcontext2.services.ProductDeliveryService;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            ProductDeliveryService productDeliveryService = context.getBean(ProductDeliveryService.class);

            productDeliveryService.addSomeProducts();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

}
