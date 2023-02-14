import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author sheli
 * leetcode2023/2/14每日一题
 **/
public class problem1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        // 前缀和
        int[] s = new int[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i <= n; i++) {
            if (hours[i - 1] > 8) {
                s[i] = s[i - 1] + 1;
            } else {
                s[i] = s[i - 1] - 1;
            }
            // 组成单调栈，如果r-stack.peek>0，说明满足
            if (s[stack.peek()] > s[i]) {
                stack.push(i);
            }
        }
        int res = 0;
        for (int r = n; r > 0; r--) {
            while (!stack.isEmpty() && s[stack.peek()] < s[r]) {
                res = Math.max(res, r - stack.pop());
            }
        }
        return res;
    }
}
