package Annotation0701;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;


class User {
    @NotNull(message = "ID must not be null")
    private String id;

    @Size(min = 2, max = 20, message = "Username must be between 2 and 20 characters")
    private String username;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    public User(String id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

}