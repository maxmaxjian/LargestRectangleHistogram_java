import java.sql.SQLOutput;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution1 implements Solution {
    @Override
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int len = heights.length;
        int[] left = new int[len], right = new int[len];
        left[0] = -1;
        for (int i = 1; i < len; i++) {
            int k = i-1;
            while (k >= 0 && heights[k] >= heights[i]) {
                k--;
            }
            left[i] = k;
        }
        System.out.print("left = ");
        System.out.println(IntStream.of(left).boxed().collect(Collectors.toList()));

        right[len-1] = len;
        for (int i = len-2; i >= 0; i--) {
            int k = i+1;
            while (k <= len-1 && heights[k] >= heights[i]) {
                k++;
            }
            right[i] = k;
        }
        System.out.print("right = ");
        System.out.println(IntStream.of(right).boxed().collect(Collectors.toList()));

        int result = 0;
        for (int i = 0; i < len; i++) {
            result = Math.max(result, heights[i]*(right[i]-left[i]-1));
        }

        return result;
    }
}
