package app;

import app.contracts.Engine;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        app.contracts.Reader reader = new ConsoleReader();
        app.contracts.Writer writer = new ConsoleWriter();

        Engine engine = new app.core.Engine(reader, writer);
        engine.run();
    }
}
