package io.pavan;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,85,76,74,45};
        int eleIndex=linearSearch(arr,76);
        System.out.println(eleIndex);
        }
    static int linearSearch(int[] arr, int target){
        if(arr.length==0)
            return -1;
        for (int index = 0; index < arr.length; index++) {
            if(target==arr[index])
                return index;
        }
        return -1;
    }
    }
