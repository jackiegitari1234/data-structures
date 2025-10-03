package com.patterns.problems.heap;

public class Main {
    public static void main(String[] args) {


        Heap myHeap = new Heap(); //7, 10, 4, 3, 20, 1
        myHeap.insert(7);
        myHeap.insert(10);
        myHeap.insert(4);
        myHeap.insert(3);
        myHeap.insert(20);
        myHeap.insert(15);
        System.out.println(myHeap.getHeap());

        myHeap.remove();
        System.out.println(myHeap.getHeap());
        myHeap.remove();
        System.out.println(myHeap.getHeap());
        myHeap.remove();
        System.out.println(myHeap.getHeap());
        myHeap.remove();
        System.out.println(myHeap.getHeap());
        myHeap.remove();
        System.out.println(myHeap.getHeap());


    }
}
