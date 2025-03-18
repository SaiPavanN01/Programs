package io.pavan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        BinaryTree bt = new BinaryTree();
//        Scanner sc = new Scanner(System.in);
//        bt.populate(sc);
////        bt.display();
//        bt.prettyDisplay();
//        BST bst = new BST();
////        bst.populate(new int[]{6,5,8,10,4,3});
//        bst.populateSorted(new int[]{1,2,3,4,5,6});
//        bst.display();
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
        // tree.display();

        System.out.println(tree.query(1, 6));
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.length());
    }
}
