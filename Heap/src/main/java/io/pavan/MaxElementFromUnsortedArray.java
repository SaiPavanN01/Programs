package io.pavan;

import java.util.*;

public class MaxElementFromUnsortedArray {
    // Helper function to heapify the list in-place (max-heap)
    private static void heapify(List<Integer> list, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && list.get(left) > list.get(largest)) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && list.get(right) > list.get(largest)) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            Collections.swap(list, i, largest);
            heapify(list, n, largest); // Recursively heapify the affected subtree
        }
    }

    // Function to build a max-heap from the list
    private static void buildMaxHeap(List<Integer> list) {
        int n = list.size();

        // Start from the last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }
    }

    public static int findMaxElement(List<Integer> list) {
        // Build a max-heap
        buildMaxHeap(list);

        // The maximum element will now be at the root of the heap
        return list.getFirst();
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> unsorted = Arrays.asList(6,1,4,7,12,15,17,22,4,5);
        System.out.println(findMaxElement(unsorted));
    }
}
