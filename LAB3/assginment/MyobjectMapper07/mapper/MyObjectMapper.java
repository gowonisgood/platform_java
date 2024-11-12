package mapper;

import parser.MyJsonParser;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.lang.Object;

public class MyObjectMapper<T>{
    
    private MyJsonParser parser;

    public MyObjectMapper() {
        this.parser = new MyJsonParser();
    }

    public T readValue(String jsonString, Class<T> clazz) throws Exception {
        HashMap<String, Object> jsonMap = parser.parse(jsonString);
        T obj = clazz.getDeclaredConstructor().newInstance();

        for (String key : jsonMap.keySet()) {
            //Implement your code
            try {
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);
                field.set(obj, jsonMap.get(key));
            } catch (NoSuchFieldException e) {
                // Handle the case where JSON key doesn't match any field in the class
                System.err.println("No field found for key: " + key);
            }
        }
        
        return obj;
    }
}