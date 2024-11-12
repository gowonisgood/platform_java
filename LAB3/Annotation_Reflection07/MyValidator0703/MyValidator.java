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
            if(field.isAnnotationPresent(NotNull.class)) {
                try {
                    Object value = field.get(obj);
                    if(value == null) {
                        NotNull notNull = field.getAnnotation(NotNull.class);
                        violations.add(notNull.message());
                    }
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }

            // Check for @Size annotation
            if(field.isAnnotationPresent(Size.class)) {
                try{
                    Object value = field.get(obj);
                    //애네터이션 값 들고오기
                    Size size = field.getAnnotation(Size.class);
                    int min = size.min();
                    int max = size.max();

                    //String name = field.getName();
                    //System.out.println("debug: "+name);
                    //int namelen = name.length();

                    if(value instanceof String) {
                        String stringValue = (String) value;
                        int length = stringValue.length();

                        if(length < min || length > max) {
                            violations.add(size.message());
                        }
                    }

                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }

        }

        // Return set of violation messages, if any
        return violations;
    }
}