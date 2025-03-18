package io.pavan;
// https://leetcode.com/problems/diameter-of-binary-tree
public class DiameterOfBT {
    public class TreeNode{
        private  int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }
    public int height(TreeNode node){
        if(node== null)
            return 0;
        int leftHeight= height(node.left);
        int rightHeight= height(node.right);
        int dia = leftHeight+rightHeight+1;
        diameter= Math.max(dia,diameter);
        return Math.max(leftHeight, rightHeight)+1;
    }
}
