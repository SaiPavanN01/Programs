package io.pavan;

import java.util.Scanner;

public class BinaryTree {
    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }
    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root value to be inserted");
        int val = scanner.nextInt();
        Node node = new Node(val);
        populate(scanner, node);
    }
    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to insert the left of"+node.value);
        boolean left= scanner.nextBoolean();
        if(left){
            System.out.println("Enter the node to be inserted on left for "+node.value);
            int val=scanner.nextInt();
            node.left= new Node(val);
            populate(scanner,node.left);
        }
        System.out.println("Do you want to insert the right of"+node.value);
        boolean right= scanner.nextBoolean();
        if(right){
            System.out.println("Enter the node to be inserted on right for "+node.value);
            int val=scanner.nextInt();
            node.right= new Node(val);
            populate(scanner,node.right);
        }
    }
    public void display(){
        display(root,"");
    }
    private void display(Node node, String indent){
        if(node == null)
            return;
        System.out.println(indent+node.value);
        display(node.left,indent+"\t");
        display(node.left,indent+"\t");
    }
    public void prettyDisplay(){
        prettyDisplay(root,0);
    }
    private void prettyDisplay(Node node, int level){
        if(node == null)
            return;
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|---------> "+node.value);
        }else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);
        if(level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|---------> "+node.value);
        }else {
            System.out.println(node.value);
        }

    }
}
