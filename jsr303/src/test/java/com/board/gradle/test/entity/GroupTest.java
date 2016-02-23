package com.board.gradle.test.entity;

import com.board.gradle.entity.Course;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by roman.andrianov on 2/23/16.
 */
public class GroupTest {

    private static Validator validator;
    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();
    }


}
