package com.board.gradle.valiadator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by roman.andrianov on 2/23/16.
 */
public class CheckDateValidator implements ConstraintValidator<CheckDate, String> {

    String dateFormat[];

    @Override
    public void initialize(CheckDate constraintAnnotation) {
        dateFormat = constraintAnnotation.dateFormat();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return valid(value);
    }

    private boolean valid(String dateString) {
        boolean valid = false;
        if (dateString.length() == 0) {
            return true;
        }
        for (String format : dateFormat) {
            if (!valid && (format.isEmpty() || format.toUpperCase().equals("YYYY-MM-DD"))) {
                valid = isValidDate(dateString, "yyyy-MM-dd");
            }
            if(!valid && (format.isEmpty() || format.toUpperCase().equals("YYYY-MM"))) {
                valid = isValidDate(dateString, "yyyy-MM");
            }
            if(!valid && (format.isEmpty() || format.toUpperCase().equals("YYYY"))) {
                valid = isValidDate(dateString, "yyyy");
            }
        }
        return valid;
    }

    private boolean isValidDate(String dateString, String pattern) {
        boolean valid = true;
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            dateString = dateString.trim();
            date = simpleDateFormat.parse(pattern);
        } catch (ParseException e) {
            valid = false;
        }
        return valid;
    }

}
