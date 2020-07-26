package practice.week2;

import practice.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Day2_MaxWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> leftMostNode = new ArrayList<>();
        return dfs(root, 1, 0, leftMostNode);
    }

    private int dfs(TreeNode root, int id, int level, List<Integer> leftMostNode) {
        if (root == null) return 0;

        if (level == leftMostNode.size())
            leftMostNode.add(id);

        return Math.max(id - leftMostNode.get(level) + 1, Math.max(dfs(root.left, id*2, level + 1, leftMostNode), dfs(root.right, id*2 + 1, level + 1, leftMostNode)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3, new TreeNode(5), new TreeNode(3));
        root.right = new TreeNode(2, null, new TreeNode(9));
        System.out.println(new Day2_MaxWidthBinaryTree().widthOfBinaryTree(root));
    }
}

