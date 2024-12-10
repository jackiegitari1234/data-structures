package com.patterns.problems.stack_study;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(2);
//        stack.printStack();

        stack.push(1);
        stack.pop();
        stack.printStack();

//        stack.printTop();
//        stack.printHeight();

    }
}
