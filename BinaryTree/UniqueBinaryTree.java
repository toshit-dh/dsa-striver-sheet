package BinaryTree;


import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryTree {
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTree(1, n);
    }
    public static List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = generateTree(start, i - 1);
            List<TreeNode> rightSubtrees = generateTree(i + 1, end);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        List<TreeNode> nodes = generateTrees(3);
    }
}