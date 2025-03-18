package io.pavan;

import java.util.*;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
public class VerticalTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
        public List<List<Integer>> verticalTraversal(TreeNode node) {
            int col =0;
            List<List<Integer>> ans = new ArrayList<>();
            Queue<Map.Entry<TreeNode,Integer>> queue = new ArrayDeque<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            int min=0;
            int max=0;
            queue.offer(new AbstractMap.SimpleEntry<>(node,col));
            while(!queue.isEmpty()){
                Map.Entry<TreeNode, Integer> removed = queue.poll();
                node=removed.getKey();
                col= removed.getValue();

                if(node!=null){
                    if(!map.containsKey(col)){
                        map.put(col,new ArrayList<>());
                    }
                    map.get(col).add(node.val);
                    min = Math.min(min,col);
                    max = Math.max(max,col);

                    queue.offer(new AbstractMap.SimpleEntry<>(node.left,col-1));
                    queue.offer(new AbstractMap.SimpleEntry<>(node.right,col+1));
                }
            }
            for (int i = min; i <= max; i++) {
                ans.add(map.get(i));
            }
            return ans;
        }

}
