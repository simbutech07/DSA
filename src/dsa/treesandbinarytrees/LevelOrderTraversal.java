package dsa.treesandbinarytrees;

import java.util.LinkedList;
import java.util.Queue;

//Breadth-First Search or BFS
public class LevelOrderTraversal {

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

        levelOrder(root);
    }

    private static void levelOrder(Node root) {

        if(root == null) return;

        // Initialize a queue to keep track of the nodes
        Queue<Node> queue = new LinkedList<>();

        // Add the root node to the queue to start the process
        queue.add(root);

        // Keep looping until the queue becomes empty
        while (!queue.isEmpty()){

            // Get and Remove the front node from the queue
            Node current = queue.poll();

            // Print the current node's data
            System.out.print(current.data + " ");

            // Enqueue the left child if it exists
            if (current.left != null) {
                queue.add(current.left);
            }

            // Enqueue the right child if it exists
            if (current.right != null) {
                queue.add(current.right);
            }

        }



    }

}
