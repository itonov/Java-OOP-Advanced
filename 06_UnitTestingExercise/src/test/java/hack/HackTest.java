package hack;

import org.junit.Assert;
import org.junit.Test;

public class HackTest {
    private static final int NEGATIVE_THREE = -3;
    private static final int POSITIVE_THREE = 3;

    @Test
    public void mathAbsReturnsPositiveNumber() {
        Assert.assertEquals("Math.abs isn't working properly", POSITIVE_THREE, Math.abs(NEGATIVE_THREE));
    }

    @Test
    public void lineSeparatorShouldSeparateLines() {
        String textWithLineSeparator = "a" + System.lineSeparator() + "a";
        String check = "a\r\na";
        Assert.assertTrue("LineSeparator isn't working properly", check.equals(textWithLineSeparator));
    }

    @Test
    public void mathFloorShouldRoundToTheLowerNumber() {
        Assert.assertTrue("Math.floor isn't rounding to the lower num", 2 == Math.floor(2.7));
    }
}
