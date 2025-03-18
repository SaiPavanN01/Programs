package io.pavan.dfs;

public class PathExistInBTFromRootToLeaf {
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

    public boolean helper(TreeNode node, int[] nums, int index){
        if(node == null)
                return false;
        if(index >= nums.length || node.val != nums[index])
            return false;
        if(node.left == null && node.right == null && index== nums.length-1)
            return true;
        return helper(node.left,nums,index+1) || helper(node.right,nums,index+1);
    }
}
