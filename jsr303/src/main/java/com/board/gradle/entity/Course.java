package com.board.gradle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @NotBlank
    private String title;
    @Min(12)
    private int seatCount;
    @AssertTrue(message = "The classroom must be available", groups = CourseChecks.class) private boolean available;
    @Valid
    private Teacher teacher;
}
