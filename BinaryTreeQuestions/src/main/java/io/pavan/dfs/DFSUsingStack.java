package io.pavan.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSUsingStack {
    public static class TreeNode {
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
    static void dfsStackPre(TreeNode node){
        if(node == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.empty()){
            TreeNode removed = stack.pop();
            System.out.print(removed+" ");
            if(removed.right!=null)
                stack.push(removed.right);
            if(removed.left!=null)
                stack.push(removed.left);
        }
    }

    static List<Integer> dfsStackPost(TreeNode node){
        List<Integer> list = new ArrayList<>();
        if(node == null)
            return list;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node);
        while(!stack1.isEmpty()){
            TreeNode removed = stack1.pop();
            stack2.push(removed);
            if(removed.left!=null)
                stack1.push(removed.left);
            if(removed.right!=null)
                stack1.push(removed.right);
        }
        while(!stack2.empty()){
            list.add(stack2.pop().val);
        }
        return list;
    }

    static List<Integer> dfsStackIn(TreeNode node){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while(current != null && !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current=current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }

    public static void main(String[] args) {
        var dfsUsingStack = new DFSUsingStack();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(dfsStackIn(root));
        System.out.println(dfsStackPost(root));
        dfsUsingStack.dfsStackPre(root);
    }
}
