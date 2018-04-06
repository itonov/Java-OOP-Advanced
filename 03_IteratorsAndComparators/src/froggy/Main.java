package froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split("[,\\s]+")).map(Integer::valueOf).collect(Collectors.toList());
        Lake lake = new Lake(nums);
        List<Integer> result = new ArrayList<>();
        int index = 0;

        for (int num : lake) {
            if (index == 0 || index % 2 == 0) {
                result.add(num);
            }
            index++;
        }

        index = 0;

        for (int num : lake) {
            if (index % 2 != 0) {
                result.add(num);
            }
            index++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.get(0));

        for (int i = 1; i < result.size(); i++) {
            sb.append(", ").append(result.get(i));
        }

        System.out.println(sb.toString());
    }
}
