package com.board.gradle.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by roman.andrianov on 2/23/16.
 */
public class Person {
    @NotBlank(message = "Please enter first name.")
    @Size(max = 16, message = "First name must be at most 16 characters.")
    private String firstname;
    @NotBlank(message = "Please enter last name.")
    @Size(min=2,max = 16, message = "Last name must be between 2 and 16 characters.")
    private String lastname;
    @Past( message = "Birthdate must be in the past.")
    private Date DateOfBirth;
}
