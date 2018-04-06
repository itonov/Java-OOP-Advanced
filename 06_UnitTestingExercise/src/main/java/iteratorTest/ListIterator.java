package iteratorTest;

import sun.plugin.dom.exception.InvalidStateException;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class ListIterator {
    private int index;
    private List<String> data;

    public ListIterator(List<String> data) throws OperationNotSupportedException {
        if (data == null) {
            throw new OperationNotSupportedException();
        }
        this.data = data;
        this.index = 0;
    }

    public boolean move() {
        if (this.index < this.data.size() - 1) {
            this.index++;
            return true;
        } else {
            return false;
        }
    }

    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    public void print() {
        if (this.data.isEmpty()) {
            throw new InvalidStateException("Invalid Operation!");
        }

        System.out.println(this.data.get(this.index));
    }
}
