package telephony;

public class Smartphone implements Callable, Browsable {

    @Override
    public String browseUrl(String url) {
        char[] letters = url.toCharArray();

        for (char letter : letters) {
            if (Character.isDigit(letter)) {
                return "Invalid URL!";
            }
        }
        return String.format("Browsing: %s!", url);
    }

    @Override
    public String makeCall(String number) {
        char[] letters = number.toCharArray();

        for (char letter : letters) {
            if (!Character.isDigit(letter)) {
                return "Invalid number!";
            }
        }
        return String.format("Calling... %s", number);
    }
}
