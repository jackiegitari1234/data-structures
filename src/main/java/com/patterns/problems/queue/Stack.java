package com.patterns.problems.queue;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
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
        return stackList.isEmpty();
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value){
        stackList.add(value);
    }

    public T pop1(){
        if (stackList.isEmpty()) return null;
        stackList.reversed();
     return stackList.removeLast();
    }

    String reverseString(String initialString){
        String reversed = "";
        List<Character> characters = new ArrayList<>();
        for(Character i: initialString.toCharArray()){
            characters.add(i);
        }
        while (!characters.isEmpty()){
            reversed = reversed+characters.removeLast();
        }
        return reversed;
    }

    public T pop() {
        if (isEmpty()) return null;
        return stackList.remove(stackList.size() - 1);
    }


}
