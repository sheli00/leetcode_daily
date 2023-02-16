/**
 * @Author sheli
 * leetcode2023/2/16每日一题
 **/
public class problem2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] newNums = new int[101];
        for (int num : nums) {
            newNums[num]++;
        }
        int res = 0, pair = 0;
        for (int num : newNums) {
            res += num % 2;
            pair += num / 2;
        }
        return new int[] {pair, res};
    }
}
