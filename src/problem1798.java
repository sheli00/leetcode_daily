import java.util.Arrays;

public class problem1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins); //排序
        int maxReach = 1;
        for (int i : coins) {
            // 假如当前数为5，之前最大值大于等于4，那么最大值+5
            if (i < maxReach + 1) {
                maxReach += i;
            } else {
                return maxReach;
            }
        }
        return maxReach;
    }
}
