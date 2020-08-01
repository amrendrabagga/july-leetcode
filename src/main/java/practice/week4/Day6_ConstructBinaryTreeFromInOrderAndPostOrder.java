package practice.week4;

import practice.utility.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Day6_ConstructBinaryTreeFromInOrderAndPostOrder {
    Map<Integer, Integer> index = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length==0) return null;

        Map<Integer, Integer> indexByKey = new HashMap<>();
        for (int i = 0;i < inorder.length; i++) {
            indexByKey.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        for (int i= postorder.length-2; i>=0; i--) {
            constructTree(root, postorder[i], indexByKey);
        }
        return root;
    }

    private TreeNode constructTree(TreeNode root, int val, Map<Integer, Integer> indexByKey) {
        if (root == null) return new TreeNode(val);

        if (indexByKey.get(val) > indexByKey.get(root.val))
            root.right = constructTree(root.right, val, indexByKey);
        else root.left = constructTree(root.left, val, indexByKey);
        return root;
    }

    public TreeNode buildTreeEfficient(int[] inorder, int[] postorder) {
        if (postorder.length==0) return null;

        for (int i=0; i<inorder.length; i++) {
            index.put(inorder[i], i);
        }
        Index postIn = new Index(postorder.length - 1);
        TreeNode root = constructTreeEfficient(inorder, postorder, 0, inorder.length-1, postIn);
        return root;
    }

    private TreeNode constructTreeEfficient(int[] inorder, int[] postorder, int startIn, int endIn, Index postIn) {
        if (startIn > endIn) return null;
        TreeNode node = new TreeNode(postorder[postIn.index]);
        postIn.index--;
        if (startIn == endIn) { // no children
            return node;
        }
        node.right = constructTreeEfficient(inorder, postorder, index.get(node.val) + 1, endIn, postIn);
        node.left = constructTreeEfficient(inorder, postorder, startIn, index.get(node.val) -1, postIn);
        return node;
    }

    public static void main(String[] args) {
        Day6_ConstructBinaryTreeFromInOrderAndPostOrder obj = new Day6_ConstructBinaryTreeFromInOrderAndPostOrder();
        obj.printTree(obj.buildTreeEfficient(new int[]{4, 8, 2, 5, 1, 6, 3, 7}, new int[]{8, 4, 5, 2, 6, 7, 3, 1}));
    }

    private void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
        }
    }

    static class Index {
        int index;
        Index(int index) {
            this.index = index;
        }
    }
}
