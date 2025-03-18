package io.pavan;

import java.util.Stack;
// https://leetcode.com/problems/valid-parentheses
public class ValidParantheses {
    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
    }
    static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        if(str.isEmpty())
            return false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{')
                stack.push(str.charAt(i));
            else{
                if((stack.peek() == '(' && str.charAt(i) == ')') || (stack.peek() == '{' && str.charAt(i) == '}') || (stack.peek() == '[' && str.charAt(i) == ']')){
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
