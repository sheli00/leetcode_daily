import java.util.*;
/**
 * from: leetcode20230208每日一题
 * author: sheli
 * */
public class problem1233 {
    public List<String> removeSubfolders(String[] folder) {
        // 字典序排序
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String pre = res.get(res.size() - 1);
            if (!beginWith(pre, folder[i])) {
                res.add(folder[i]);
            }
        }
        return res;
    }
    // 判断是否是前缀
    boolean beginWith(String str1, String str2) {
        int length = str1.length();
        int length2 = str2.length();
        if (length >= length2) return false;
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        if (str2.charAt(length) != '/') {
            return false;
        }
        return true;
    }
}
