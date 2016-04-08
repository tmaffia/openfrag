package com.openfrag.conf;

import org.hibernate.dialect.H2Dialect;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tmaffia on 4/8/16.
 */

@Configurable
public class PersistenceConfig {

    @Value("${entity.package}")
    private String ENTITY_PACKAGE;

    @Value("#{dataSource")
    private DataSource dataSource;

    @Bean
    public Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.dialect", H2Dialect.class.getName());
        return props;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibJpaVendorAdapter.setShowSql(true);
        hibJpaVendorAdapter.setGenerateDdl(true);
        hibJpaVendorAdapter.setDatabase(Database.H2);
        return hibJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(this.dataSource);
        em.setJpaPropertyMap(this.jpaProperties());
        em.setJpaVendorAdapter(this.jpaVendorAdapter());
        em.setPackagesToScan(ENTITY_PACKAGE);
        return em;
    }
}
