package io.pavan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SD {
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
    // Encodes a tree to a single string.
    public String serialize(TreeNode node){
        List<String> list = new ArrayList<>();
        helper(node, list);
        return String.join(", ", list);
    }
    public void helper(TreeNode node, List<String> list) {
        if(node == null){
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        helper(node.left,list);
        helper(node.right,list);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<String>(Arrays.asList(data.split(",")));
        Collections.reverse(list);
        TreeNode node = helper2(list);
        return node;
    }

    public TreeNode helper2(List<String> list) {
        String val = list.remove(list.size() - 1);
        val =val.trim();
        if(val.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper2(list);
        node.right=helper2(list);
        return node;
    }

}


