package io.pavan;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class ZigZagOrderTraversal {
    public class TreeNode{
        private  int value;
        private  TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean reverse = false;
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<size;i++){

                if(!reverse){
                    TreeNode currentNode = deque.pollFirst();
                    currentLevel.add(currentNode.value);
                    if(currentNode.left!=null)
                        deque.addLast(currentNode.left);
                    if(currentNode.right!=null)
                        deque.addLast(currentNode.right);
                }else{
                    TreeNode currentNode = deque.pollLast();
                    currentLevel.add(currentNode.value);
                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }
                }
            }
            reverse =!reverse;
            result.add(currentLevel);
        }
        return result;
    }
}
