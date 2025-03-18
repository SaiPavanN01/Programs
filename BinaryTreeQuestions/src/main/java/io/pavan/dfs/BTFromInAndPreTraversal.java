package io.pavan.dfs;

import java.util.Arrays;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
public class BTFromInAndPreTraversal {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        int r = preorder[0];
        int index =0;
        for(int i =0;i<inorder.length;i++){
            if(inorder[i] == r){
                index=i;
                break;
            }
        }
        TreeNode root = new TreeNode(r);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return root;
    }
}
