package com.patterns.problems.queue;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(isBalancedParentheses("((())())"));
    }

    static boolean isBalancedParentheses(String input){
        Stack<Character> stack = new Stack<>();
        for (char i: input.toCharArray()){
            if (i ==  '('){
                stack.push(i);
            } else {
                if ( stack.isEmpty() || '(' != (stack.pop())){
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
