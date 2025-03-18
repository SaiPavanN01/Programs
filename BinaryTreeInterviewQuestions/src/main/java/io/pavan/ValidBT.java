package io.pavan;
// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidBT {
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
    public boolean isValidBST(TreeNode root) {

        return helper(root,null,null);
    }
    public boolean helper(TreeNode node, Integer low, Integer high){
        if(node ==null)
            return true;
        if(low!=null && node.value<=low)
            return false;
        if(high!=null && node.value>=high)
            return false;
        boolean leftTree = helper(node.left,low, node.value);
        boolean rightTree = helper(node.right, node.value,high);

        return leftTree && rightTree;
    }
}
