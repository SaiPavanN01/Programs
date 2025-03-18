package io.pavan;

import java.util.LinkedList;
import java.util.Queue;
// Google
public class LevelOrderSuccesorOfANode {
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
    TreeNode findSuccessor(TreeNode root, int search){
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
                TreeNode currentNode = queue.poll();
                if(currentNode.left!=null)
                    queue.offer(currentNode.left);
                if(currentNode.right!=null)
                    queue.offer(currentNode.right);
                if(currentNode.value==search)
                    break;
        }
        return queue.peek();
    }
}
