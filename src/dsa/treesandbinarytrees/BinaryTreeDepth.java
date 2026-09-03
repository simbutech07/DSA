package dsa.treesandbinarytrees;

import java.util.LinkedList;
import java.util.Queue;

//DFS - Depth-First Search
public class BinaryTreeDepth {

    static class Node{

        int data;
        Node left;
        Node right;

        Node(int x){
            this.data =x;
            this.left = this.right = null;
        }
    }

    public static void main() {

        // Create binary tree
        //       1
        //      /  \
        //    2     3
        //   / \     \
        //  4   5     6

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Binary tree recursive : "+binaryTreeDepthRecursive(root));

        System.out.println("Binary tree recursive : "+binaryTreeDepthIterative(root));
    }

    private static int binaryTreeDepthIterative(Node root) {

        //Iterative DFS Method as an alternative approach
        Queue<Node> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);


        while (!queue.isEmpty()){
            int levelSize = queue.size();

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {

                Node currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }
            // Increment depth after processing a full level
            depth++;
        }
        return depth;
    }

    private static int binaryTreeDepthRecursive(Node root) {

        if(root == null) return 0;

        // Recursively find the depth of left and right subtrees
        int leftDepth = binaryTreeDepthRecursive(root.left);
        int rightDepth = binaryTreeDepthRecursive(root.right);

        // The depth of the current node is 1 plus the maximum of its subtrees
        return Math.max(leftDepth,rightDepth)+1;
    }


}
