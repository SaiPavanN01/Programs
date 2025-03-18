package io.pavan;
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBT {
    public class TreeNode{
        private  int value;
        private  TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while(current!=null){
            if(current.left!=null){
                TreeNode temp = current.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=current.right;
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }
    }
}
