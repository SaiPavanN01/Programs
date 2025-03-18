package io.pavan;

public class ConvertBTToDLL {
    LLNode head;
    LLNode tail;
    class LLNode {
        private int val;
        LLNode next;
        LLNode prev;

        public LLNode() {
        }

        public LLNode(int val) {
            this.val = val;
            this.next=null;
            this.prev=null;
        }

        public LLNode(LLNode next, LLNode prev) {
            this.next = next;
            this.prev = prev;
        }
    }
    class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode convert(TreeNode root){
        if(root == null)
            return null;
        helper(root);
        return root;
    }

    private void helper(TreeNode node) {
        if(node == null){
            return;
        }
        helper(node.left);
        LLNode newNode = new LLNode(node.val);
        if(head == null){
            head = newNode;
            tail=newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail=newNode;
        }

        helper(node.right);
    }
}
