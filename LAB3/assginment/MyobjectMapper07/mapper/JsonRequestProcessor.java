package mapper;

import annotation.RequestJsonBody;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class JsonRequestProcessor {
    public static void processRequest(Object instance, String methodName, String jsonString) throws Exception {
        MyObjectMapper mapper = new MyObjectMapper();
        Method[] methods = instance.getClass().getMethods();
        
        for (Method method : methods) {
            // Implement your code
            if(method.getName().equals(methodName)) {
                Parameter[] parameters = method.getParameters();
                for(int i = 0; i < parameters.length; i++) {
                    if(parameters[i].isAnnotationPresent(RequestJsonBody.class)){
                        Object paramObject = mapper.readValue(jsonString, parameters[i].getType());
                        method.invoke(instance, paramObject);
                        return;
                    }
                }
            }
        }
    }
}
