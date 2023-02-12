/**
 * @Author sheli
 * leetcode2023/2/12每日一题
 **/
public class problem1138 {
    public String alphabetBoardPath(String target) {
        // 存储前一个字符的坐标
        int x = 0, y = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            // 计算当前字符的坐标
            char c = target.charAt(i);
            int nx = (c - 'a') / 5;
            int ny = (c - 'a') % 5;
            // 有限考虑上移和左移，避免因为z字符出错
            if (nx < x) {
                for (int j = 0; j < x - nx; j++) {
                    res.append("U");
                }
            }
            if (ny < y) {
                for (int j = 0; j < y - ny; j++) {
                    res.append("L");
                }
            }
            if (nx > x) {
                for (int j = 0; j < nx - x; j++) {
                    res.append("D");
                }
            }
            if (ny > y) {
                for (int j = 0; j < ny - y; j++) {
                    res.append("R");
                }
            }
            res.append("!");

            // 更新坐标
            x = nx;
            y = ny;
        }
        return res.toString();
    }
}
