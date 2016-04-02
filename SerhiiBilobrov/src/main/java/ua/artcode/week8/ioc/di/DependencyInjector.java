package ua.artcode.week8.ioc.di;

import ua.artcode.week8.ioc.common.Inject;
import ua.artcode.week8.ioc.db.AppDB;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by serhii on 02.04.16.
 */
public class DependencyInjector {

    private Map<String, Object> context;

    public DependencyInjector() {
        context = new HashMap<>();
        context.put("ua.artcode.week8.ioc.db.AppDB", new AppDB());
    }

    public void inject(Object target) {
        Class cl = target.getClass();

        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(Inject.class)) {
                String typeName = field.getType().getName();
                // do injection
                Object injectObj = context.get(typeName);
                try {
                    field.set(target, injectObj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


        }

    }


}
