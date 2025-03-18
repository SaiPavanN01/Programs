package io.pavan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BFS {

    public class TreeNode{
       private  int value;
       private TreeNode left;
       private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null)
            return results;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currentNode=queue.poll();
                currentLevel.add(currentNode.value);
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            results.add(currentLevel);
        }
        return results;
    }
}
