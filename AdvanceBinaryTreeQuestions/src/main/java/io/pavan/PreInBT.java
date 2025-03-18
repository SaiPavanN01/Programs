package io.pavan;

import java.util.HashMap;
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class PreInBT {
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
    public TreeNode buildTree(int[] preorder, int[] inorder){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i );
        }
        int[] index ={0};
        return helper(preorder,inorder,0,preorder.length-1,map,index);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map, int[] index) {
        if(left>right)
            return null;
        int current = preorder[index[0]];
        index[0]++;

        TreeNode node = new TreeNode(current);
        if(left == right)
            return node;
        int inOrderIndex = map.get(current);
        node.left = helper(preorder,inorder, left, inOrderIndex-1,map, index);
        node.right = helper(preorder,inorder,inOrderIndex+1,right,map,index);
        return node;
    }
}
