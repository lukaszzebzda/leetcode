package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BinaryTreePaths257 {

    private static List<String> allPaths = new ArrayList<>();
    private static List<String> currentPath = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<String> res = binaryTreePaths(root);

        for (String row : res) {
            System.out.println(row);
        }
    }



    public static List<String> binaryTreePaths(TreeNode root) {
        depthFirstSearch(root);
        return allPaths;
    }

    private static void depthFirstSearch(TreeNode node) {
        // Base
        if (node == null){
            return;
        }

        currentPath.add(String.valueOf(node.val));

        if(node.left == null && node.right == null){
            allPaths.add(String.join("->", currentPath));
        }
        else {
            depthFirstSearch(node.left);
            depthFirstSearch(node.right);
        }

        currentPath.remove(currentPath.size()-1);
    }
}
