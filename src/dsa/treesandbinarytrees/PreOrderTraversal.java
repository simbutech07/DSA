package dsa.treesandbinarytrees;

import java.util.ArrayList;

//root->left->right
public class PreOrderTraversal {

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
        preOrder(root,result);

        System.out.println(result);

    }

    private static void preOrder(Node node, ArrayList<Integer> result) {

        if(node == null) return;

        // Visit the current node
        result.add(node.data);

        // Traverse the left subtree first
        preOrder(node.left,result);

        // Traverse the right subtree last
        preOrder(node.right,result);

    }
}
