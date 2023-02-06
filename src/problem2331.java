import javax.swing.tree.TreeNode;

/**
* from: leetcode20230206每日一题
* author: sheli
* */

public class problem2331 {
    public boolean evaluateTree(TreeNode root) {
        //如果是叶子节点
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        else {
            boolean left = evaluateTree(root.left);
            boolean right = evaluateTree(root.right);
            if (root.val == 2) {
                return left || right;
            } else {
                return left && right;
            }
        }
    }
}
