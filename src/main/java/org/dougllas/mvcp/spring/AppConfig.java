package org.dougllas.mvcp.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.Serializable;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Criado por dougllas.sousa em 05/06/2017.
 */

@Configuration
@ComponentScan("org.dougllas.mvcp")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.dougllas.mvcp.repository")
public class AppConfig implements Serializable {

    public static ApplicationContextProvider PROVIDER_INSTANCE;

    @Bean("applicationContextProvider")
    public ApplicationContextProvider applicationContextProvider(){
        return PROVIDER_INSTANCE =  new ApplicationContextProvider();
    }

    @Bean("applicationProperties")
    public ResourceBundle applicationProperties(){
        return ResourceBundle.getBundle("jdbc");
    }

    @Bean("dataSource")
    public DataSource dataSource(
           @Qualifier("applicationProperties") ResourceBundle bundle
    ){
        String driver   = bundle.getString("datasource.driverClassName");
        String url      = bundle.getString("datasource.url");
        String userName = bundle.getString("datasource.username");
        String password = bundle.getString("datasource.password");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean("jpaProperties")
    public Properties jpaProperties(){
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        jpaProperties.put("hibernate.temp.use_jdbc_metadata_defaults", false);
        jpaProperties.put("hibernate.show_sql", true);
        jpaProperties.put("hibernate.format_sql", true);
        jpaProperties.put("hibernate.generate_statistics", false);
//        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        return jpaProperties;
    }

    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("dataSource")    DataSource dataSource,
            @Qualifier("jpaProperties") Properties jpaProperties
    ){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        bean.setPersistenceUnitName("mvcpPU");
        bean.setJpaProperties(jpaProperties);
        bean.setPackagesToScan("org.dougllas.mvcp.model");
        return bean;
    }

    @Bean("entityManager")
    public SharedEntityManagerBean entityManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory
    ){
        SharedEntityManagerBean entityManagerBean = new SharedEntityManagerBean();
        entityManagerBean.setEntityManagerFactory(entityManagerFactory);
        return entityManagerBean;
    }

    @Bean("transactionManager")
    public JpaTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory
    ){
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean("transactionTemplate")
    public TransactionTemplate transactionTemplate(
            @Qualifier("transactionManager") JpaTransactionManager transactionManager
    ){
        return new TransactionTemplate(transactionManager);
    }

    public class ApplicationContextProvider implements ApplicationContextAware {

        private org.springframework.context.ApplicationContext applicationContext;

        public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
        }

        public ApplicationContext getApplicationContext() {
            return applicationContext;
        }

        public <T> T getBean(Class<T> beanClass){
            return applicationContext.getBean(beanClass);
        }

        public <T> T getBean(String beanName){
            return (T) applicationContext.getBean(beanName);
        }
    }
}