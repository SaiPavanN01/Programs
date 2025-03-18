package io.pavan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS2 {
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.value);
                if(currentNode.left!=null)
                    queue.offer(currentNode.left);
                if(currentNode.right!=null)
                    queue.offer(currentNode.right);
            }
            result.add(0,levelList);
        }
        return result;
    }
}
