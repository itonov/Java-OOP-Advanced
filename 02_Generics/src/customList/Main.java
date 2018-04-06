package customList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        CustomList<String> myList = new CustomList<>();

        while (!"end".equalsIgnoreCase(inputLine)) {
            String[] tokens = inputLine.split(" ");
            String action = tokens[0];

            switch (action) {
                case "Add":
                    myList.add(tokens[1]);
                    break;
                case "Remove":
                    myList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(myList.contains(tokens[1]));
                    break;
                case "Swap":
                    myList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(myList.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(myList.getMax());
                    break;
                case "Min":
                    System.out.println(myList.getMin());
                    break;
                case "Print":
                    for (Object element : myList) {
                        System.out.println(element);
                    }
                    break;
                case "Sort":
                    Sorter.Sort(myList.getData());
                default:
                    break;
            }
            inputLine = reader.readLine();
        }
    }
}
