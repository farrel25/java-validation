package com.farrel.javavalidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Person {

    @NotBlank(message = "first name can not blank")
    @Size(max = 20, message = "first name length must below 20 characters")
    private String firstName;

    @NotBlank(message = "last name can not blank")
    @Size(max = 20, message = "last name length must below 20 characters")
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
