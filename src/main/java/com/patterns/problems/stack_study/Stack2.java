package com.patterns.problems.stack_study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//Push POP for a Stack That Uses an ArrayList
public class Stack2<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public String reverseString2(String value){
        Stack<Character> characters = new Stack<>();
        String reverse = "";
        for (char c: value.toCharArray()) {
            characters.push(c);
        }

        while (!characters.isEmpty()){
            reverse += characters.pop();
        }
        return reverse;

    }

    public int size() {
        return stackList.size();
    }

    public void push(T value) {
        this.stackList.add(value);

    }
    public T pop() {
        if (isEmpty()) return null;
        return this.stackList.remove(size() - 1);

    }

    public static String reverseString(String string) {
        Stack2<Character> stack = new Stack2<>();
        String reversedString = "";

        for (char c : string.toCharArray()) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        return reversedString;
    }
}
