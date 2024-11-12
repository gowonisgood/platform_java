package Annotation0701;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Set;

public class ValidationTest {
    private static final ValidatorFactory factory;
    private static final Validator validator;
    static {
        Logger hibernateValidatorLogger = Logger.getLogger("org.hibernate.validator.internal.util.Version");
        hibernateValidatorLogger.setLevel(Level.SEVERE);

        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static void main(String[] args) {
        User user = new User(null, "J", 17);
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        List<ConstraintViolation<User>> sortedViolations = new ArrayList<>(violations);

        sortedViolations.sort(Comparator.comparing(violation -> violation.getPropertyPath().toString()));

        for (ConstraintViolation<User> violation : sortedViolations) {
            System.out.println(violation.getMessage());
        }
    }
}