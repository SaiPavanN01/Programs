package io.pavan;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PathExistsInBTFromAnyNode {
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
    public int countPaths(TreeNode root, int sum){
        List<Integer> path = new ArrayList<>();
        return helper(root,path,sum);
    }

    private int helper(TreeNode node, List<Integer> path, int sum) {
        if(node == null)
            return 0;
        path.add(node.value);
        int pathSum = 0;
        int count =0;
        ListIterator<Integer> itr = path.listIterator();
        while(itr.hasPrevious()){
            pathSum+=itr.previous();
            if(sum == pathSum)
                count++;
        }
        count += helper(node.left,path,sum) + helper(node.right,path,sum);
        //backtrack
        path.remove(path.size()-1);
        return count;
    }
}
