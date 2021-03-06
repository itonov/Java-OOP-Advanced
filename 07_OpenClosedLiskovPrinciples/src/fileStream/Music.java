package fileStream;

public class Music implements Streamable {

    private String artist;
    private String album;
    private int length;
    private int bytesSent;

    public Music(String artist, String album, int length, int bytesSent) {
        this.artist = artist;
        this.album = album;
        this.length = length;
        this.bytesSent = bytesSent;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getBytesSent() {
        return this.bytesSent;
    }
}
