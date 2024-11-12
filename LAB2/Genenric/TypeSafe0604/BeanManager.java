package Java_platform.Genenric.TypeSafe0604;

import java.util.HashMap;
import java.util.Map;
import java.lang.Object;
import java.lang.Integer;
import java.lang.String;
import java.lang.Double;


public class BeanManager {

    private Map<Class<?>, Object> beans = new HashMap<>();

    public <T> void addBean(Class<T> type, T instance){
        beans.put(type, instance);
    }

    public <T> T getBean(Class<T> type){
        return type.cast(beans.get(type));
    }
}
