package io.pavan;
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointer {
    public class Node {
        private  int value;
        private Node left;
        private Node right;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node left, Node right, Node next) {
            this.left = left;
            this.right = right;
            this.next=next;
        }
    }
    public Node connect(Node root) {
        if(root == null)
            return null;
        Node leftMost=root;
        while(leftMost.left!=null){
            Node currentNode = leftMost;
            while(currentNode!=null){
                // to connect to the right child
                currentNode.left.next = currentNode.right;
                if(currentNode.next!=null){
                    // to connect the intermidiate node
                    currentNode.right.next=currentNode.next.left;
                }
                // to connect the nodes at right
                currentNode=currentNode.next;
            }

            leftMost=leftMost.left;
        }
        return root;
    }
}
