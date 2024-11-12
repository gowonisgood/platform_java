package Java_platform.Genenric.OurSimpleRepository0603.repositories;
import Java_platform.Genenric.OurSimpleRepository0603.models.Person;

import java.util.ArrayList;
import java.util.List;

public abstract class OurSimpleRepository<T extends Person> {
    protected List<T> entities = new ArrayList<>();

    public void save(T entity) {
        // Implement your code
        entities.add(entity);
    }

    public T findById(Long id) {
        // Implement your code
        for (T entity : entities) {
            Long entityId = entity.getId();
            if(id.equals(entityId)) return entity;
        }
        return null;
    }

    public List<T> findAll() {
        // Implement your code
       return entities;
    }

    public void deleteById(Long id) {
        // Implement your code
        for (T entity : entities) {
            Long entityId = entity.getId();
            if(id.equals(entityId)) {
                entities.remove(entity);
                break;
            }
            }
        }
}

