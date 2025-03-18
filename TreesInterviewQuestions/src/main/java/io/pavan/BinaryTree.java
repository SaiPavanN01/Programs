package io.pavan;

import java.util.Scanner;

public class BinaryTree {
    public BinaryTree() {

    }

    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    Node root;
    public void populate(Scanner scanner){
        System.out.println("Please enter the root value");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }
    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to left node of "+node.val);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Please enter the left node value of "+node.val);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner,node.left);
        }
        System.out.println("Do you want to right node of "+node.val);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Please enter the right node value of "+node.val);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner,node.right);
        }
    }
    public void display(){
        prettyDisplay(root,0);
    }
    private void display(Node node, String indent){
        if(node == null)
            return;
        System.out.println(indent + node.val);
        display(node.left,indent + "\t");
        display(node.right,indent + "\t");
    }

    public void prettyDisplay(Node node, int level){
        if(node == null)
            return;
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->"+node.val);
        }else{
            System.out.println(node.val);
        }
        prettyDisplay(node.left,level+1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);
        tree.display();

    }
}
