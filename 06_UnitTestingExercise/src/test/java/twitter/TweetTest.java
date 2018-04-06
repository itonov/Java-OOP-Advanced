package twitter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TweetTest {
    private static final String MESSAGE = "message";

    private Tweet tweet;

    @Before
    public void initialize() {
        this.tweet = new TweetImpl(MESSAGE);
    }

    @Test
    public void checkConstructorAndGetMessage() {
        Assert.assertEquals("Tweet message isn't the same", MESSAGE, this.tweet.getMessage());
    }

    @Test
    public void getMessageIsCalledAtLeastOnce() {
        Tweet mock = Mockito.mock(Tweet.class);
        mock.getMessage();
        Mockito.verify(mock, Mockito.atLeastOnce()).getMessage();
    }
}
