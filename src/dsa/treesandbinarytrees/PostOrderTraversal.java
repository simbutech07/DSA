package dsa.treesandbinarytrees;

import java.util.ArrayList;

//left->right->root
public class PostOrderTraversal {

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

        ArrayList<Integer> result = new ArrayList<>();
        postOrder(root,result);

        System.out.println(result);

    }

    private static void postOrder(Node node, ArrayList<Integer> result) {

        if(node == null) return;

        // Traverse the left subtree first
        postOrder(node.left,result);

        // Traverse the right subtree last
        postOrder(node.right,result);

        // Visit the current node
        result.add(node.data);

    }
}
