/**
 * @Author sheli
 * leetcode2023/2/15每日一题
 **/
public class problem1250 {
    public boolean isGoodArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = gcd(res, nums[i]);
            if (res == 1) {
                break;
            }
        }
        return res == 1;
    }
    int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
