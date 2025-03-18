package io.pavan.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {
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
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }
}