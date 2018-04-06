package listyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] createParams = reader.readLine().split(" ");
        ListyIterator iterator;
        if (createParams.length == 1) {
            iterator = new ListyIterator();
        } else {
            iterator = new ListyIterator(Arrays.copyOfRange(createParams, 1, createParams.length));
        }

        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" ");
            String action = tokens[0];
            switch (action) {
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(iterator.print());
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                case "PrintAll":
                    System.out.println(iterator.printAll());
                default:
                    break;
            }
            input = reader.readLine();
        }
    }
}
