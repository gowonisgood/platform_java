package Java_platform.GenericBeanManager051.pnu.cafe.core;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.HashMap;

public class BeanManager {
    private Map<Class<?>,Bean> beans = new HashMap<>();

    public <T extends Bean> void registerBean(Class<T> beanClass, T beanInstance) {
        beanInstance.initialize();
        beans.put(beanClass, beanInstance);
    }

    public <T extends Bean> T getOrCreateBean(Class<T> beanClass) {
        T bean = (T) beans.get(beanClass);
        if (bean == null) {
            try{
                Constructor<T> constructor = beanClass.getConstructor();
                bean = constructor.newInstance();
                registerBean(beanClass, bean);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return bean;
    }

    public void close(){
        for(Bean bean : beans.values()) {
            bean.destroy();
        }
        beans.clear();
    }
}
