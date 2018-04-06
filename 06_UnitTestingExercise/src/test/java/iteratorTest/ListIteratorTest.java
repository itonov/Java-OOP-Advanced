package iteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.plugin.dom.exception.InvalidStateException;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class ListIteratorTest {

    private ListIterator iterator;

    @Before
    public void initialize() throws OperationNotSupportedException {
        List<String> initialList = new ArrayList<>();
        initialList.add("pesho");
        initialList.add("pesho");
        this.iterator = new ListIterator(initialList);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullElement() throws OperationNotSupportedException {
        ListIterator test1 = new ListIterator(null);
    }

    @Test
    public void moveShouldReturnTrue() {
        Assert.assertEquals("Move command isn't returning true",true, this.iterator.move());
    }

    @Test
    public void moveShouldReturnFalse() {
        this.iterator.move();
        Assert.assertEquals("Move command isn't returning false", false, this.iterator.move());
    }

    @Test
    public void hasNextShouldReturnTrue() {
        Assert.assertEquals("hasNext isn't returning true",true, this.iterator.hasNext());
    }

    @Test
    public void hasNextShouldReturnFalse() {
        this.iterator.move();
        this.iterator.move();
        Assert.assertEquals("hasNext isn't returning false", false, this.iterator.hasNext());
    }

    @Test(expected = InvalidStateException.class)
    public void callPrintOnEmptyCollection() throws OperationNotSupportedException {
        ListIterator testIterator = new ListIterator(new ArrayList<>());
        testIterator.print();
    }
}
