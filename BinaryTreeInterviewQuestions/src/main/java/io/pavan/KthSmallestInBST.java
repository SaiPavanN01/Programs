package io.pavan;
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestInBST {
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
    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root,k).value;
    }

    public TreeNode helper(TreeNode root, int k){
        if(root == null)
            return null;
        TreeNode left = helper(root.left,k);

        if(left!=null)
            return left;
        count++;

        if(k==count)
            return root;
        return helper(root.right,k);
    }
}
