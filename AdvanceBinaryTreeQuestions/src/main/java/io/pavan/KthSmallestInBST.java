package io.pavan;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
public class KthSmallestInBST {
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
    // Solution 1
    /*
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        helper(root,heap,k);
        int ans =0;
        for (int i = 0; i < k; i++) {
           ans =heap.poll();
        }
        return ans;
    }

    private void helper(TreeNode node, PriorityQueue<Integer> heap, int k) {
        if(node == null)
            return;
        helper(node.left,heap,k);
        heap.add(node.val);
        helper(node.right,heap,k);
    }
    */
   private int k=0;
   private int ans;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        helper(root);
        return ans;
    }

    private void helper(TreeNode node) {
        if(node == null)
            return;
        helper(node.left);
        k--;
        if(k==0){
            ans = node.val;
            return;
        }

        helper(node.right);
    }
}
