package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class reflection = Reflection.class;

        Arrays.stream(reflection.getDeclaredFields())
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.println(field.getName() + " must be private!"));

        Arrays.stream(reflection.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get"))
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .forEach(method -> System.out.println(method.getName() + " have to be public!"));

        Arrays.stream(reflection.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set"))
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .forEach(method -> System.out.println(method.getName() + " have to be private!"));

    }
}
