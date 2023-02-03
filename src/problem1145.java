import javax.swing.tree.TreeNode;

public class problem1145 {
    TreeNode xNode;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // 1. n节点的左子树节点个数为nleft，右子树节点个数为nright，其它节点个数为nother
        // 2. 有解的情况：三者最大值减去其它两个>1
        int nleft, nright, nother;
        // 3. 定位节点x，计算其左节点和右节点即可
        find(root, x);
        nleft = getSubTreeSize(xNode.left);
        nright = getSubTreeSize(xNode.right);
        nother = n - nleft - nright - 1;
        if (nleft - nright - nother > 1 || nright - nleft - nother > 1 || nother - nleft - nright > 1) return true;
        return false;
    }
    void find(TreeNode node, int x) {
        if (xNode != null || node == null) {
            return;
        }
        if (node.val == x) {
            xNode = node;
            return;
        }
        find(node.left, x);
        find(node.right, x);
    }
    int getSubTreeSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSubTreeSize(node.right) + getSubTreeSize(node.left);
    }
}
