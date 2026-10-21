package MODULETWO.ONE.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeRoleValidator implements ConstraintValidator<EmployeRoleValidation,Integer> {


    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value <= 1) {
            return false;
        }

        if (value == 2) {
            return true;
        }

        // Reject even numbers greater than 2
        if (value % 2 == 0) {
            return false;
        }

        // Check odd divisors
        for (int i = 3; i <= value / i; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }
}
