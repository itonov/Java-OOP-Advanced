package twitter;

public class ClientImpl implements Client {
    @Override
    public void receiveMessage(String message) {
        System.out.println(message);
    }
}
