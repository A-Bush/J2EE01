package com.board.gradle.valiadator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckDateValidator.class)
public @interface CheckDate {

    String message() default "{javax.validation.constraints.CheckDate.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String[] dateFormat() default {};
}
