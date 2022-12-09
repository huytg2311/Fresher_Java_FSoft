//package com.example.config;
//
//
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.web.config.EnableSpringDataWebSupport;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.spring5.ISpringTemplateEngine;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import org.thymeleaf.templatemode.TemplateMode;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//
//@Configuration
//@EnableWebMvc
//@EnableTransactionManagement
//@ComponentScan("com.example")
//@EnableSpringDataWebSupport
//public class ApplicationConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
//
//    private ApplicationContext applicationContext;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//
//    //Thymeleaf Configuration
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        templateResolver.setCharacterEncoding("UTF-8");
//        return templateResolver;
//    }
//
//    @Bean
//    public TemplateEngine templateEngine() {
//        TemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        return templateEngine;
//    }
//
//    @Bean
//    public ThymeleafViewResolver viewResolver() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());
//        viewResolver.setCharacterEncoding("UTF-8");
//        return viewResolver;
//    }
//
//    @Bean
//    public DriverManagerDataSource getDataSource() {
//        DriverManagerDataSource datasource = new DriverManagerDataSource();
//        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        datasource.setUrl("jdbc:mysql://localhost:3306/test01?allowPublicKeyRetrieval=true&useSSL=false");
//        datasource.setUsername("root");
//        datasource.setPassword("huytg2311");
//        return datasource;
//    }
//
//    final Properties hibernateProperties() {
//        Configuration cfg = new Configuration();
//        cfg.setProperty("hibernate.dialect", "com.mysql.jdbc.Driver");
//        cfg.setProperty("hibernate.connection.datasource", "jdbc:mysql://localhost:3306/hibernate");
//// other configuration properties
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactory.setDataSource(getDataSource());
//        entityManagerFactory.setPackagesToScan(new String[]{"com.example.model"});
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
//        entityManagerFactory.setJpaProperties(hibernateProperties());
//        return entityManagerFactory;
//    }
//
//    //JPA
//    @Bean
//    @Qualifier(value = "entityManager")
//    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
//        return entityManagerFactory.createEntityManager();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//
//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasenames("message");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
//}