package MyValidator0703;
//import jakarta.validation.Validation;

public @interface NotNull {
    String message() default "This field cannot be null";
}
