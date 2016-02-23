package com.board.gradle.entity;


import com.board.gradle.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

/*
Bean Validation API Hibernate Validator adds some useful constraints to those built into EE 7.
The full list can be found here Hibernate Custom Constraints
Some of the more interesting ones include:
@NotEmpty
@NotBlank
@Email(regexp=, flags=)
@SafeHtml (whitelistType=, additionalTags=)
@URL(protocol=, host=, port=, regexp=, flags=)
*/


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Last name is compulsory")
    @NotBlank(message = "Last name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "Last name has invalid characters")
    private String lastName;
    @NotNull(message = "First name is compulsory")
    @NotBlank(message = "First name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
    private String firstName;
    @NotNull(message = "Gender is compulsory")
    private Gender gender;
    @NotNull(message="Email Address is compulsory")
    @NotBlank(message="Email Address is compulsory")
    @Email(message = "Email Address is not a valid format")
    private String emailAddress;
    @Past(message = "Date of Birth must be the past")
    @NotNull
    private Date dateOfBirth;
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    @Max(value = 150, message = "Age must be less than or equal to 150")
    private Integer age;
}
