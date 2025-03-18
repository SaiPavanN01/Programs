package io.pavan;

import java.util.Stack;

public class MinInsertionsBalanceParentheses {
    public static void main(String[] args) {
        System.out.println(minInsertions("(())"));
    }
    public static int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
                count++;
            }
            else{
                if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')'){

                    if(i+1 < s.length() && s.charAt(i+1) == ')'){
                        count=count-2;
                        stack.pop();
                    }
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        return count+1;
    }
}
