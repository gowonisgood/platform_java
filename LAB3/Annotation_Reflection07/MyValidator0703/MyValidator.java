package MyValidator0703;


import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;


public class MyValidator {
    public static Set<String> validate(Object obj) {
        Set<String> violations = new HashSet<>();

        // Iterate over all fields of the object's class
        for (Field field : obj.getClass().getDeclaredFields()) {
            // Allows access to private fields
            field.setAccessible(true);

            // Check for @NotNull annotation


            // Check for @Size annotation

        }

        // Return set of violation messages, if any
        return violations;
    }
}