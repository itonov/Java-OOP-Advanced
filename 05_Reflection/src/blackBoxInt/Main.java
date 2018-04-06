package blackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Constructor<BlackBoxInt> constructor = (Constructor<BlackBoxInt>) BlackBoxInt.class.getDeclaredConstructors()[1];
        constructor.setAccessible(true);
        BlackBoxInt box = constructor.newInstance();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            Method[] methods = box.getClass().getDeclaredMethods();

            for (Method method : methods) {
                method.setAccessible(true);
            }

            for (Method method : methods) {
                if (method.getName().equalsIgnoreCase(command)) {
                    method.invoke(box, value);
                    break;
                }
            }

            Field result = box.getClass().getDeclaredField("innerValue");
            result.setAccessible(true);
            System.out.println(result.getInt(box));

            input = reader.readLine();
        }
    }
}
