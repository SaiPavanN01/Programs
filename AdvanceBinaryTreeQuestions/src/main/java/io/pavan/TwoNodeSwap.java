package io.pavan;

public class TwoNodeSwap {
    public class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void helper(TreeNode root){
        if(root == null)
            return;
        iot(root);
    }
    public void iot(TreeNode node){
        if(node == null)
            return;
        iot(node.left);
        if(prev!=null && prev.val < node.val){
            if(first==null)
                first=prev;
            second=node;
        }
        prev = node;
        iot(node.right);
    }
}
