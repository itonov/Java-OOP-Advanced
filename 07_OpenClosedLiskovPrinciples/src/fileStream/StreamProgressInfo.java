package fileStream;

public class StreamProgressInfo {
    private Streamable stream;

    public StreamProgressInfo(Streamable stream) {
        this.stream = stream;
    }

    public int calculateCurrentPercent() {
        return (this.stream.getBytesSent() * 100) / this.stream.getLength();
    }

    public static void main(String[] args) {
        StreamProgressInfo info = new StreamProgressInfo(new Music("gosho", "pesho", 21, 21));
        System.out.println(info.calculateCurrentPercent());
    }
}
