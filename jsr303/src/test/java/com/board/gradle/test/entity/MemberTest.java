package com.board.gradle.test.entity;

import com.board.gradle.entity.Member;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class MemberTest {

    private static Validator validator;


    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testMemberWIthNoValues() {
        Member member = new Member();
        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        assertEquals(violations.size(), 5);
    }
}
