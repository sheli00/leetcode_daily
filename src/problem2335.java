import java.util.Arrays;

/**
 * @Author sheli
 * leetcode2023/2/11每日一题
 **/
public class problem2335 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        //情况1 最多的比其它两个加起来多
        if (amount[2] >= amount[0] + amount[1]) {
            return amount[2];
        }
        //情况2 构成三角形
        //比如3,3,4。3+3=6，多出来2个，先x和y内部消化一次，变成2，2,4，就刚好符合第一种情况
        int t = amount[0] + amount[1] - amount[2];
        return (t + 1) / 2 + amount[2];
    }
}
