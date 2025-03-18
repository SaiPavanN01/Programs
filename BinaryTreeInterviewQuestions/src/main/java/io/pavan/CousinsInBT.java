package io.pavan;
// https://leetcode.com/problems/cousins-in-binary-tree/
public class CousinsInBT {
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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);

        return (level(root, xx, 0) == level(root, yy, 0) && (!siblings(root,xx,yy)) );


    }
    public TreeNode findNode(TreeNode root, int x){
        if(root == null)
            return null;
        if(root.value == x)
            return root;
        TreeNode n = findNode(root.left,x);
        if(n!=null)
            return n;
        return findNode(root.right,x);
    }

    public boolean siblings(TreeNode node, TreeNode x, TreeNode y){
        if (node == null) {
            return false;
        }
        return ((node.left == x && node.right ==y) || (node.left == y && node.right ==x) || siblings(node.left,x,y) || siblings(node.right,x,y));
    }
    public int level(TreeNode node, TreeNode x, int lev){
        if(node== null)
            return 0;
        if(node==x)
            return lev;
        int l = level(node.left,x,lev+1);
        if(l!=0)
            return l;
        return level(node.right,x,lev+1);
    }
}
