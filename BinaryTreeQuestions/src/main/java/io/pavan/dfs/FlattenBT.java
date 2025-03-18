package io.pavan.dfs;
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBT {
    public class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode current = root;
        while(current!=null){
            TreeNode leftMost = current;
            if(leftMost.left != null){
                TreeNode temp = leftMost.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right=current.left;
                current.left=null;
            }
            current = current.right;
        }
    }
}
