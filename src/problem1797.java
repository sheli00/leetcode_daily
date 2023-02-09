import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author sheli
 * leetcode2023/2/9每日一题
 **/
public class problem1797 {
    private int timeToLive;
    private Map<String, Integer> tokens;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        this.tokens.put(tokenId, currentTime + this.timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        // 如果token存在，且未到过期时间，更新
        if (this.tokens.getOrDefault(tokenId, 0) > currentTime) {
            this.tokens.put(tokenId, currentTime + this.timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for (int time : this.tokens.values()) {
            if (time > currentTime) {
                res++;
            }
        }
        return res;
    }
}
