package io.pavan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// https://leetcode.com/problems/average-of-levels-in-binary-tree/
public class AverageLevelsInBinaryTree {
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double levelSum =0;
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                levelSum+=currentNode.value;
                if(currentNode.left!=null)
                    queue.offer(currentNode.left);
                if(currentNode.right!=null)
                    queue.offer(currentNode.right);
            }
            levelSum/=size;
            result.add(levelSum);
        }
        return result;
    }
}
