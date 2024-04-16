package com.farrel.javavalidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintViolationTest {

    private ValidatorFactory validatorFactory;

    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testValidationBlank() {

        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("\nMessage: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Annotation: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value: " + violation.getInvalidValue());
            System.out.println("Property Path: " + violation.getPropertyPath());
            //violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
        }
    }

    @Test
    void testValidationSize() {

        Person person = new Person();
        person.setFirstName("FarrelFarrelFarrelFarrelFarrelFarrelFarrelFarrelFarrelFarrel");
        person.setLastName("PutraPutraPutraPutraPutraPutraPutraPutraPutraPutraPutraPutra");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("\nMessage: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Annotation: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value: " + violation.getInvalidValue());
            System.out.println("Property Path: " + violation.getPropertyPath());
            //violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
        }
    }

    @Test
    void testValidationSuccess() {

        Person person = new Person();
        person.setFirstName("Farrel");
        person.setLastName("Putra");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertEquals(0, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("\nMessage: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Annotation: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value: " + violation.getInvalidValue());
            System.out.println("Property Path: " + violation.getPropertyPath());
            //violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
        }
    }
}
