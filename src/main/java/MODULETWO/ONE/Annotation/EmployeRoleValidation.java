package MODULETWO.ONE.Annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeRoleValidator.class)
public @interface EmployeRoleValidation {
    String message() default "{Enter a Prime Number}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
