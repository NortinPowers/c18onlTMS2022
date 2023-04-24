package by.tms.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static by.tms.utils.Constants.ErrorMessage.AGE_LIMIT;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UserBirthdayValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface UserBirthdayConstraint {
    String message() default AGE_LIMIT;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}