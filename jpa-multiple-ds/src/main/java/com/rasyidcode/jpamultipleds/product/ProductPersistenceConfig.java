package com.rasyidcode.jpamultipleds.product;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;

@PropertySource({"classpath:multiple-ds.properties"})
@EnableJpaRepositories(
        basePackages = "com.rasyidcode.jpamultipleds.product",
        entityManagerFactoryRef = "productEntityManager",
        transactionManagerRef = "productTransactionManager"
)
@Configuration
public class ProductPersistenceConfig {

    private final Environment environment;

    public ProductPersistenceConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean productEntityManager(DataSource productDataSource) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));

        entityManager.setDataSource(productDataSource);
        entityManager.setPackagesToScan("com.rasyidcode.jpamultipleds.product");
        entityManager.setJpaVendorAdapter(vendorAdapter);
        entityManager.setJpaPropertyMap(properties);

        return entityManager;
    }

    @Bean
    public DataSource productDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("jdbc.datasource.driver-class-name")));
        dataSource.setUrl(environment.getProperty("product_db.datasource.url"));
        dataSource.setUsername(environment.getProperty("jdbc.datasource.username"));
        dataSource.setPassword(environment.getProperty("jdbc.datasource.password"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager productTransactionManager(EntityManagerFactory productEntityManager) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(productEntityManager);
        return transactionManager;
    }

}
