package twitter;

import org.junit.Test;
import org.mockito.Mockito;

public class ClientTest {

    private static final String MESSAGE = "message";

    @Test
    public void receiveMessageCalledOneTime() {
        Client client = Mockito.mock(ClientImpl.class);
        client.receiveMessage(MESSAGE);
        Mockito.verify(client, Mockito.atLeastOnce()).receiveMessage(MESSAGE);
    }
}
