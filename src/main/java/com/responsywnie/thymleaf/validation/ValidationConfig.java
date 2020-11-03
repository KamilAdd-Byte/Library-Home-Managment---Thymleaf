package com.responsywnie.thymleaf.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@ComponentScan
@Configuration
public class ValidationConfig {

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }

}
