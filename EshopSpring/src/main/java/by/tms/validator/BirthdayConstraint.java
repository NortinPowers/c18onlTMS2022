package by.tms.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = BirthdayValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface BirthdayConstraint {
    String message() default "Registration is available from the age of 18";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}