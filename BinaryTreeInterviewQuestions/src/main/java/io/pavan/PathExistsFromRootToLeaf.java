package io.pavan;

public class PathExistsFromRootToLeaf {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean pathExists(TreeNode root, int[] arr){
        return helper(root,arr,0);
    }

    private boolean helper(TreeNode node, int[] arr, int index) {
       if(node == null)
           return false;
       if((index >= arr.length-1) && (node.val != arr[index]))
           return false;
       if(node.left == null && node.right == null && index == arr.length-1)
           return true;
       return helper(node.left,arr,index+1) || helper(node.right,arr,index+1);
    }
}
