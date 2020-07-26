package practice.week4;

import practice.utility.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Day1_ZigZagTraversalOfTree {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) return Collections.emptyList();
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        List<List<Integer>> res = new ArrayList<>();
        currentLevel.push(root);
        boolean leftToRight = true;
        List<Integer> level = new ArrayList<>();

        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.pop();
            level.add(node.val);
            if(leftToRight) {
                if (node.left != null)
                    nextLevel.push(node.left);
                if (node.right != null)
                    nextLevel.push(node.right);
            }
            else if(!leftToRight) {
                if (node.right != null)
                    nextLevel.push(node.right);
                if (node.left != null)
                    nextLevel.push(node.left);
            }

            if(currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                res.add(level);
                level = new ArrayList<>();
                // swap stacks
                Stack<TreeNode> tmp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        List<Integer> list = new ArrayList<>(stack);
        list.addAll(stack);
        System.out.println(list);*/

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println(new Day1_ZigZagTraversalOfTree().zigzagLevelOrder(root));
    }
}
