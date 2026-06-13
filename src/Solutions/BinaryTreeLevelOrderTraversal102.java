package Solutions;

import java.util.*;

public class BinaryTreeLevelOrderTraversal102 {
    static int depth = -1;
    static List<List<Integer>> found = new ArrayList<>();



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> res = levelOrderUsingBFS(root);

        for (List<Integer> sol : res) {
            for (Integer one : sol) {
                System.out.println(one + " ");
            }
            System.out.println("break");
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        depthFirstSearch(root);
        return found;
    }

    public static void depthFirstSearch(TreeNode node){
        if(node == null) return;

        depth+=1;
        if(found.size() <= depth){
            List<Integer> newFloor = new ArrayList<>();
            newFloor.add(node.val);
            found.add(newFloor);
        }else{
            List<Integer> floor = found.get(depth);
            floor.add(node.val);
            found.set(depth, new ArrayList<Integer>(floor));
        }

        depthFirstSearch(node.left);
        depthFirstSearch(node.right);

        depth -= 1;
    }

    public static List<List<Integer>> levelOrderUsingBFS(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if (root == null){
            return results;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> currentLevel = new ArrayList<>();

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }

            results.add(currentLevel);
        }
        return results;
    }


}
