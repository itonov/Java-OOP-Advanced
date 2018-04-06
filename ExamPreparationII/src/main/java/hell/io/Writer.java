package hell.io;

import hell.interfaces.OutputWriter;

public class Writer implements OutputWriter {
    @Override
    public void writeLine(String output, Object... params) {
        System.out.print(output);
    }

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
