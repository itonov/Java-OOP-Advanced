package genericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        List<Double> data = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            data.add(Double.parseDouble(reader.readLine()));
        }
        double value = Double.parseDouble(reader.readLine());
        Box box = new Box(data);

        System.out.println(box.countOfElement(data, value));
    }
}
