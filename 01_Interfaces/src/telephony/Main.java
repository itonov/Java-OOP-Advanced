package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbersToCall = reader.readLine().split(" ");
        String[] urls = reader.readLine().split(" ");
        Smartphone smartphone = new Smartphone();
        for (String number : numbersToCall) {
            System.out.println(smartphone.makeCall(number));
        }

        for (String url : urls) {
            System.out.println(smartphone.browseUrl(url));
        }
    }
}
