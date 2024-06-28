package com.rasyidcode.jpamultipleds;

import com.rasyidcode.jpamultipleds.user.User;
import com.rasyidcode.jpamultipleds.user.UserRepository;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;

//@PropertySource({"classpath:multiple-ds.properties"})
@SpringBootApplication
public class Application {

//    private static final Logger logger = LoggerFactory.getLogger(Application.class);

//    private final Environment environment;
//
//    public Application(Environment environment) {
//        this.environment = environment;
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//
//        factory.setDataSource(dataSource);
//        factory.setPackagesToScan("com.rasyidcode.jpamultipleds.user");
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setJpaPropertyMap(properties);
//
//        return factory;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("jdbc.datasource.driver-class-name")));
//        dataSource.setUrl(environment.getProperty("user_db.datasource.url"));
//        dataSource.setUsername(environment.getProperty("jdbc.datasource.username"));
//        dataSource.setPassword(environment.getProperty("jdbc.datasource.password"));
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//    @Bean
//    public CommandLineRunner commandLineRunner(UserRepository userRepository) {
//        return args -> {
//            User user = new User("john doe", "john.doe@example.com", 23);
//            logger.info("user: {}", user);
//            userRepository.save(user);
//        };
//    }

}
