package com.patterns.problems.heap;


public class Heap2 {

    public static int findKthSmallest(int[] nums, int k){
        Heap heap = new Heap();
        for (int num :nums){
            heap.insert(num);
            if (heap.getHeap().size() > k){
                heap.remove();
            }
        }
        return heap.remove();
    }
}
