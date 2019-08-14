import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int[] input;
    private int expected;
    private Solution soln = new Solution2();

    public SolutionTest(int[] input, int output) {
        this.input = input;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {new int[]{2,1,5,6,2,3}, 10},
                {new int[]{2,1,5,6,3,3}, 12},
                {new int[]{5,4,1,2}, 8}
        });
    }

    @Test
    public void testFunction() {
        assertEquals(expected, soln.largestRectangleArea(input));
    }
}