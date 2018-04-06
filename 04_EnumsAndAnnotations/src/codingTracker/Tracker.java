package codingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "gosho")
    public void randomMethod() {

    }

    @Author(name = "pesho")
    public void testMethod() {

    }

    @Author(name = "pesho")
    public void anotherTestMethod() {

    }

    @Author(name = "gosho")
    public static void printMethodsByAuthor(Class<?> cl) {
        Method[] methods = cl.getMethods();
        Map<String, List<String>> methodByAuthor = new HashMap<>();
        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);

            if (annotation != null) {
                methodByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }

        for (Map.Entry<String, List<String>> entry : methodByAuthor.entrySet()) {
            String author = entry.getKey();
            List<String> currentMethods = entry.getValue();
            System.out.println(author + ": " + String.join(", ", currentMethods));
        }
    }
}
