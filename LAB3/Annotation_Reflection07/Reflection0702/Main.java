package Reflection0702;
//import edu.pnu.model.User;

import java.lang.reflect.*;
import java.lang.Class;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Long id = 101L;
        String username = "Heungmin Son";
        int age = 32;

        // Implement your code
        // 1. Get the User class dynamically using the full package name
        Class<?> userClass = Class.forName("edu.pnu.model.User");

        // 2. Get the constructor of User class with specific parameter types
        Constructor<?> constructor = userClass.getConstructor(Long.class, String.class, int.class);

        // 3. Create an instance of User class using reflection
        User user = (User)constructor.newInstance(id,username,age);

        // 4. Output user details using getter methods
        /*Method getIdMethod = userClass.getMethod("getId");
        Method getUsernameMethod = userClass.getMethod("getUsername");
        Method getAgeMethod = userClass.getMethod("getAge");*/

        System.out.println("User Details:");
        System.out.println("ID: " + user.getId());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Age: " + user.getAge());
    }
}
