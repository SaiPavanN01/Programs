package io.pavan;

public class BST {
    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    private Node root;

    public BST() {
    }
    public boolean isEmpty()     {
        return root == null;
    }
    public int height(Node node){
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
        return node;
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if( node == null)
            return true;
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left) && balanced(node.right);
    }
    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }
    public void populateSorted(int[] nums){
        populateSorted(nums,0, nums.length);
    }
    private void populateSorted(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end-start)/2;
        insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1,end);
    }
    public void display(){
        display(root,"Root Value is : ");
    }
    private void display(Node node, String details){
        if(node == null)
            return ;
        System.out.println(details+node.value);
        display(node.left,"Left node of "+node.value+" : ");
        display(node.right,"Right node of "+node.value+" : ");
    }
}
