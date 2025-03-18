package io.pavan.bfs;

public class CousinsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);

        return (level(root,xx,0) == level(root,yy,0) && !isSibling(root,xx,yy));
    }
    boolean isSibling(TreeNode node, TreeNode xx, TreeNode yy){
        if(node == null)
            return false;
        return ((node.left == xx && node.right == yy) || (node.left == yy && node.right == xx) || isSibling(node.left,xx,yy) || isSibling(node.right,xx,yy));
    }
    TreeNode findNode(TreeNode node,int x){
        if(node == null)
            return null;
        if(node.val == x)
            return node;
        TreeNode l = findNode(node.left,x);
        if(l!=null)
            return l;
        return findNode(node.right,x);
    }
    int level(TreeNode node, TreeNode xx, int lev){
        if(node == null)
            return 0;
        if(node == xx)
            return lev;
        int l=level(node.left, xx,lev+1);
        if(l != 0)
            return l;
        return level(node.right,xx,lev+1);
    }
}
