/**
 * @Author sheli
 * leetcode2023/2/13每日一题
 **/
public class problem1234 {
    public int balancedString(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cnt[c-'A'] += 1;
        }
        // 检查是否符合
        if (check(cnt, n)) {
            return 0;
        }
        int res = n;
        for (int left = 0, right = 0; left < n; left++) {
            // right一直往右，直到满足窗口
            while (right < n && !check(cnt, n)) {
                cnt[s.charAt(right) - 'A']--;
                right++;
            }
            // 如果right到头了，直接返回
            if (!check(cnt, n)) {
                break;
            }
            res = Math.min(res, right - left);
            cnt[s.charAt(left) - 'A']++;
        }
        return res;
    }
    boolean check(int[] cnt, int n) {
        int part = n / 4;
        if (cnt['Q' - 'A'] > part || cnt['W' - 'A'] > part || cnt['E' - 'A'] > part || cnt['R' - 'A'] > part) {
            return false;
        }
        return true;
    }
}
