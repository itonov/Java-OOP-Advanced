package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();

        while (!"harvest".equalsIgnoreCase(command)) {
            Field[] fields = RichSoilLand.class.getDeclaredFields();
            switch (command) {
                case "private":
                    for (Field field : fields) {
                        if (Modifier.isPrivate(field.getModifiers())) {
                            System.out.println("private " + field.getType().getSimpleName() + " " + field.getName());
                        }
                    }
                    break;
                case "protected":
                    for (Field field : fields) {
                        if (Modifier.isProtected(field.getModifiers())) {
                            System.out.println("protected " + field.getType().getSimpleName() + " " + field.getName());
                        }
                    }
                    break;
                case "public":
                    for (Field field : fields) {
                        if (Modifier.isPublic(field.getModifiers())) {
                            System.out.println("public " + field.getType().getSimpleName() + " " + field.getName());
                        }
                    }
                    break;
                case "all":
                    for (Field field : fields) {
                        System.out.println(field.toGenericString().split(" ")[0] + " "
                                + field.getType().getSimpleName() + " " + field.getName());
                    }
                    break;
                default:
                    break;
            }
            command = reader.readLine();
        }
    }
}
