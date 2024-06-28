package com.rasyidcode.jpamultipleds.user;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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

@EnableJpaRepositories(
        basePackages = "com.rasyidcode.jpamultipleds.user",
        entityManagerFactoryRef = "userEntityManager",
        transactionManagerRef = "userTransactionManager"
)
@PropertySource({"classpath:multiple-ds.properties"})
@Configuration
public class UserPersistenceConfig {

    private final Environment environment;

    public UserPersistenceConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManager(DataSource userDataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));

        factory.setDataSource(userDataSource);
        factory.setPackagesToScan("com.rasyidcode.jpamultipleds.user");
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaPropertyMap(properties);

        return factory;
    }

    @Bean
    public DataSource userDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("jdbc.datasource.driver-class-name")));
        dataSource.setUrl(environment.getProperty("user_db.datasource.url"));
        dataSource.setUsername(environment.getProperty("jdbc.datasource.username"));
        dataSource.setPassword(environment.getProperty("jdbc.datasource.password"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager userTransactionManager(EntityManagerFactory userEntityManager) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(userEntityManager);
        return transactionManager;
    }

}
