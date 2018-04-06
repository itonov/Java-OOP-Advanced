package twitter;

public class TweetImpl implements Tweet {
    private String message;

    public TweetImpl(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
