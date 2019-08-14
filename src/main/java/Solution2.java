import java.util.Stack;

public class Solution2 implements Solution {
    @Override
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int curr = stack.pop();
                    result = Math.max(result, heights[curr] * (i - curr));
                }
                stack.push(i);
            }
        }

        if (!stack.isEmpty()) {
            int curr = heights.length;
            while (!stack.isEmpty()) {
                int idx = stack.pop();
                int prev = stack.isEmpty() ? -1 : stack.peek();
                result = Math.max(result, heights[idx]*(curr-prev-1));
            }
        }

        return result;
    }
}
