package io.pavan;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class TwoSum {
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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root,k, set);
    }
    public boolean helper(TreeNode node, int k, Set<Integer> set){
        if(node == null)
            return false;
        if(set.contains(k-node.val))
            return true;
        set.add(node.val);

        return helper(node.left,k,set) || helper(node.right,k,set);
    }
}
