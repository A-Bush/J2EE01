package com.board.gradle.entity;

import com.board.gradle.enums.Degree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @NotNull(message = "Each teacher must have a degree.",
            groups = TeacherChecks.class)
    private Degree degree;
    @AssertTrue(message = "Teacher must be certified.", groups = TeacherChecks.class)
    private boolean certified;
}
