package threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = reader.readLine().split(" ");
        Threeuple<String, String, String> threeuple1 = new Threeuple<>(line1[0] + " " + line1[1], line1[2], line1[3]);

        String[] line2 = reader.readLine().split(" ");
        boolean drunk = false;
        if (line2[2].equalsIgnoreCase("not")) {
            drunk = false;
        } else if (line2[2].equalsIgnoreCase("drunk")){
            drunk = true;
        }
        Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(line2[0], Integer.parseInt(line2[1]), drunk);

        String[] line3 = reader.readLine().split(" ");
        Threeuple<String, Double, String> threeuple3 = new Threeuple<>(line3[0], Double.parseDouble(line3[1]), line3[2]);

        System.out.println(threeuple1.getItem1() + " -> " + threeuple1.getItem2() + " -> " + threeuple1.getItem3());
        System.out.println(threeuple2.getItem1() + " -> " + threeuple2.getItem2() + " -> " + threeuple2.getItem3());
        System.out.println(threeuple3.getItem1() + " -> " + threeuple3.getItem2() + " -> " + threeuple3.getItem3());
    }
}
