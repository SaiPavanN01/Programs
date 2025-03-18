package io.pavan;

public class SegmentTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        int startInterval;
        int endInterval;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
    Node root;

    public SegmentTree(int[] nums) {
        this.root = constructTree(nums,0,nums.length-1);
    }
    public Node constructTree(int[] nums, int start, int end){
        if(start == end){
            Node leaf = new Node(start,end);
            leaf.data = nums[start];
            return leaf;
        }
        Node node = new Node(start,end);
        int mid = start + (end-start)/2;
        node.left = this.constructTree(nums,start,mid);
        node.right=  this.constructTree(nums,mid+1,end);
        node.data = node.left.data + node.right.data;
        return node;
    }
    public int query(int qsi, int qei){
        return query(root, qsi,qei);
    }
    private int query(Node node, int qsi, int qei){
        if(node.startInterval >= qsi && node.endInterval <= qei){
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            return 0;
        }else{
            return this.query(node.left,qsi,qei) + this.query(node.right,qsi,qei);
        }
    }
    public void update(int index, int value){
        this.root.data = update(root, index,value);
    }
    private int update(Node node, int index,int value){
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }else{
                int leftAns = update(node.left,index,value);
                int rightAns = update(node.right, index,value);
                node.data = leftAns+rightAns;
                return node.data;
            }
        }
        return node.data;
    }
}
