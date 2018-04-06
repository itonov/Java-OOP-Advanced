package stackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] createParams = reader.readLine().split("[,\\s]+");
        int[] initialNums = Arrays.stream(Arrays.copyOfRange(createParams, 1, createParams.length)).
                mapToInt(Integer::valueOf)
                .toArray();
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(initialNums);

        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split("[,\\s]+");
            String action = tokens[0];
            switch (action) {
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "Push":
                    stack.push(Arrays.stream(Arrays.copyOfRange(tokens, 1, tokens.length))
                            .mapToInt(Integer::valueOf)
                            .toArray());
                    break;
                default:
                    break;

            }
            input = reader.readLine();
        }

        for (int i = 0; i < 2; i++) {
            for (int num : stack) {
                System.out.println(num);
            }
        }
    }
}
