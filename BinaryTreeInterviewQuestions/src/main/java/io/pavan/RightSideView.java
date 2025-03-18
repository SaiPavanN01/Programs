package io.pavan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// https://leetcode.com/problems/binary-tree-right-side-view/
public class RightSideView {
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                if(i==size-1)
                    result.add(currentNode.value);
                if(currentNode.left!=null)
                    queue.offer(currentNode.left);
                if(currentNode.right!=null)
                    queue.offer(currentNode.right);

            }
        }
        return result;
    }
}
