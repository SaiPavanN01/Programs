package io.pavan;

import java.util.Map;
import java.util.Stack;

public class MinAddToMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("(())("));
    }
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' )
                stack.push(s.charAt(i));
            else{
                if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')')
                    stack.pop();
            }
        }
        return stack.size();
    }
}
