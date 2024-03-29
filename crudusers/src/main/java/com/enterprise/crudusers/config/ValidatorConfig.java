package com.enterprise.crudusers.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno
 */

@Configuration
public class ValidatorConfig {

	 @Bean(name = "validator")
	 public Validator setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}