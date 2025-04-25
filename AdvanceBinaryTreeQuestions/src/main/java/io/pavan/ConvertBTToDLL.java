package io.pavan;

public class ConvertBTToDLL {
    LLNode head;
    LLNode tail;
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
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private class LLNode {
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
    }

}
