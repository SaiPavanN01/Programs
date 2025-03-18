package io.pavan;

public class AVL {
    public static class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    private Node root;

    public AVL() {
    }
    public boolean isEmpty(){
        return root == null;
    }
    private int height(Node node){
        if(node == null)
            return -1;
        return node.height;
    }
    public void insert(int value){
        root = insert(root,value);
    }
    private Node insert(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.value){
            node.left = insert(node.left, value);
        }
        if(value > node.value)
            node.right = insert(node.right,value);
        node.height = Math.max(height(node.left),height(node.right))+1;
        return rotate(node);
    }
    public Node rotate(Node node){
        // left heavy
        if(height(node.left) - height(node.right) >1){
            if(height(node.left.left) - height(node.left.right) >0)
                return rightRotate(node);
            if(height(node.left.left) - height(node.left.right) < 0){
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        // right heavy
        if(height(node.left) - height(node.right) < -1){
            if(height(node.right.left) - height(node.right.right) < 0)
                return leftRotate(node);
            if(height(node.right.left) - height(node.right.right) > 0){
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left=c;
        c.right=t;
        c.height=Math.max(height(c.left),height(c.right))+1;
        p.height=Math.max(height(p.left),height(p.right))+1;
        return p;
    }

    private Node rightRotate(Node p) {
        Node c =p.left;
        Node t = c.right;

        c.right=p;
        p.left=t;
        c.height=Math.max(height(c.left),height(c.right))+1;
        p.height=Math.max(height(p.left),height(p.right))+1;
        return c;
    }
}
