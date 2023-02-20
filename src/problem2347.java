import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author sheli
 * leetcode2023/2/20每日一题
 **/
public class problem2347 {
    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> suitsSet = new HashSet<>();
        for (char suit : suits) {
            suitsSet.add(suit);
        }
        // 同花
        if (suitsSet.size() == 1) {
            return "Flush";
        }
        Map<Integer, Integer> ranksMap = new HashMap<>();
        for (int rank : ranks) {
            ranksMap.put(rank, ranksMap.getOrDefault(rank, 0) + 1);
        }
        if (ranksMap.size() == 5) {
            return "High Card";
        }
        //三条
        for (int value : ranksMap.values()) {
            if (value > 2) {
                return "Three of a Kind";
            }
        }
        return "Pair";
    }
}
