package Solutions;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    static List<Integer> currentPath = new ArrayList<>();
    static List<List<Integer>> foundSolution = new ArrayList<>();


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> res = pathSum(root, 9);

        for (List<Integer> sol : res) {
            for (Integer one : sol) {
                System.out.println(one + " ");
            }
            System.out.println("break");
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        depthFirstSearch(root, targetSum);
        return foundSolution;
    }

    public static void depthFirstSearch(TreeNode node, int remainingSum){
        if(node == null){
            return;
        }

        currentPath.add(node.val);
        remainingSum -= node.val;

        if(node.left == null && node.right == null && remainingSum  == 0){
            foundSolution.add(new ArrayList<>(currentPath));
        }
        else {
            depthFirstSearch(node.left, remainingSum);
            depthFirstSearch(node.right, remainingSum);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}
