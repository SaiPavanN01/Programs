package io.pavan;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
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
    public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return false;
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
        TreeNode left = queue.poll();
        TreeNode right = queue.poll();

        if(right == null && left == null)
            continue;
        if(right == null || left == null)
            return false;
        if(right.value != left.value)
            return false;

        queue.offer(left.left);
        queue.offer(right.right);
        queue.offer(left.right);
        queue.offer(right.left);
    }
        return true;
}
}
