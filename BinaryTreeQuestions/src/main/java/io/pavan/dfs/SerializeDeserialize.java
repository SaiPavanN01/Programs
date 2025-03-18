package io.pavan.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class SerializeDeserialize {
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
    public String serialize(TreeNode root){
        List<String> list = new ArrayList<>();
        helper(root,list);
        return String.join(",",list);
    }
    public void helper(TreeNode root, List<String> list){
        if(root == null){
            list.add("null");
            return;
        }
        list.add(String.valueOf(root.val));
        helper(root.left,list);
        helper(root.right,list);
    }
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
        Collections.reverse(list);
        TreeNode node = helper2(list);
        return node;
    }
    public TreeNode helper2(List<String> list){
        String val = list.remove(list.size()-1);
        if(val.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper2(list);
        node.right = helper2(list);
        return node;
    }
}
