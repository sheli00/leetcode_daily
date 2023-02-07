import java.util.*;

/**
 * from: leetcode20230207每日一题
 * author: sheli
 * */

public class problem1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        //哈希表存储每个员工打卡的时间
        Map<String, List<Integer>> map = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            map.putIfAbsent(name, new ArrayList<Integer>());
            int hour = (time.charAt(0)-'0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3)-'0') * 10 + (time.charAt(4) - '0');
            map.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<String>();
        Set<String> names = map.keySet();
        for (String name : names) {
            List<Integer> times = map.get(name);
            Collections.sort(times);
            //滑动窗口判断一个小时内是否出现三个打卡
            int size = times.size();
            for (int i = 2; i < size; i++) {
                int timeTail = times.get(i), timeHead = times.get(i - 2);
                if (timeTail - timeHead <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        //字典序升序
        Collections.sort(res);
        return res;
    }
}
