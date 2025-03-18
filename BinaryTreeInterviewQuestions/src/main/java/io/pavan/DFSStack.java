package io.pavan;

import java.util.Stack;

public class DFSStack {
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
    void dfsStack(TreeNode node){
        if(node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.empty()){
            TreeNode removed = stack.pop();
            System.out.print(removed+" ");
            // As the top of the stack will be left
            if(removed.right != null)
                stack.push(removed.right);
            if(removed.left != null)
                stack.push(removed.left);
        }
    }
}
