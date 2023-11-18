package org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection;

import org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

public class ApplicationContext {

    private static final HashMap<Class<?>, Object> map = new HashMap<>();


    public ApplicationContext(Class<?> clss) {
        Spring.initializeSpringContext(clss);
    }

    public <T> T getBean(Class<T> clss) throws IllegalAccessException {
        T object = (T) map.get(clss);
        if(object != null) {
            Field[] declaredFields = clss.getDeclaredFields();
            injectDependentBean(object, declaredFields);
            return object;
        }else{
            throw new RuntimeException("Bean Not Found Exception");
        }
    }

    private <T> void injectDependentBean(T object, Field[] declaredFields) throws IllegalAccessException {
        for (Field field : declaredFields) {
            if(field.isAnnotationPresent(Autowired.class)){
                field.setAccessible(true);
                Class<?> type = field.getType();
                field.set(object, getBean(type));
            }
        }

    }

    private static class Spring {

        public static void initializeSpringContext(Class<?> clss) {

            if (!clss.isAnnotationPresent(Configuration.class)) {
                throw new RuntimeException("Invalid configuration class");
            } else {
                if (clss.isAnnotationPresent(ComponentScans.class)) {
                    ComponentScans componentScans = clss.getDeclaredAnnotation(ComponentScans.class);
                    Arrays.stream(componentScans.value()).map(ComponentScan::value).forEach(Spring::createObject);
                } else if (clss.isAnnotationPresent(ComponentScan.class)) {
                    ComponentScan componentScan = clss.getDeclaredAnnotation(ComponentScan.class);
                    System.out.println(componentScan.value());
                    createObject(componentScan.value());
                } else {
                    throw new RuntimeException("Invalid component scan annotation present");
                }

            }


        }

        private static void createObject(String value) {
            try {
                File[] files = findClasses(value);
                for (File file : files) {

                    String name = value + "." + file.getName().replace(".class", "");
                    Class<?> aClass = Class.forName(name);
                    if (aClass.isAnnotationPresent(Component.class)) {
                        Object object = aClass.getConstructor().newInstance();
                        map.put(aClass, object);
                    }

                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        private static File[] findClasses(String value) throws FileNotFoundException {
//            String packageStructure = "/Users/praveenkumar/Documents/Learning/Java/Annotation/src/main/java//" + value.replace(".", "/");
            String packageStructure = "/Users/praveenkumar/Documents/Learning/Java/Annotation/target/classes/" + value.replace(".", "/");
            File file = new File(packageStructure);
            if (!file.exists()) {
                throw new RuntimeException("Package " + value + " does not exit.");
            } else {
                File[] listFiles = file.listFiles(e -> e.getName().endsWith(".class"));
                return listFiles;
            }
        }
    }
}
