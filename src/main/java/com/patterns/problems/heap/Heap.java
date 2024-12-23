package com.patterns.problems.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    List<Integer> heap;

    Heap(){
        heap = new ArrayList<>();
    }

    public List<Integer> getHeap(){
        return new ArrayList<>(heap);
    }


    public void printSize(){
        System.out.println(heap.size());
    }

    private int leftChild(int index){
        return 2*index+1;
    }

    private int rightChild(int index){
        return 2*index+2;
    }
    private int parent(int index){
        return (index -1)/2;
    }
    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value){
        if (heap == null) {
            heap = new ArrayList<>();
            heap.add(value);
            return;
        }
        heap.add(value);
        int currentIndex = heap.size()-1;
        while (currentIndex > 0){
            int parentIndex = (currentIndex-1)/2;
            int parent = heap.get(parentIndex);
            if(parent < value){
                heap.set(parentIndex, value);
                heap.set(currentIndex, parent);
            }
            currentIndex = parentIndex;
        }
    }

    public void insertMinHeap(int value){
        if (heap == null) {
            heap = new ArrayList<>();
            heap.add(value);
            return;
        }
        heap.add(value);
        int currentIndex = heap.size()-1;
        while (currentIndex > 0){
            int parentIndex = (currentIndex-1)/2;
            int parent = heap.get(parentIndex);
            if(parent > value){
                heap.set(parentIndex, value);
                heap.set(currentIndex, parent);
            }
            currentIndex = parentIndex;
        }
    }

    public Integer remove(){
        if (heap.isEmpty()) {
            return null;
        }
        int temp = heap.get(0);
        if (heap.size() == 1) {
            heap.remove(0);
            return temp;
        }
        int lastItem = heap.get(heap.size()-1);
        heap.set(0, lastItem);
        heap.remove(heap.size()-1);
        heapify(0);
        return temp;
    }

    public Integer removeMinHeap(){
        if (heap.isEmpty()) {
            return null;
        }
        int temp = heap.get(0);
        if (heap.size() == 1) {
            heap.remove(0);
            return temp;
        }
        int lastItem = heap.get(heap.size()-1);
        heap.set(0, lastItem);
        heap.remove(heap.size()-1);
        heapify(0);
        return temp;
    }


    public void heapify(int index){
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = index;
        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    public static int findKthSmallest(int[] nums, int k){
        Heap heap = new Heap();
        for (int num :nums){
            heap.insert(num);
            if (heap.getHeap().size() > 0){
                heap.remove();
            }
        }
        return heap.remove();
    }

    public static int streamMax(int[] nums, int k){
        Heap heap = new Heap();
        for (int num :nums){
            heap.insert(num);
            if (!heap.getHeap().isEmpty()){
                heap.remove();
            }
        }
        return heap.remove();
    }

    public static List<Integer> streamMax(int[] nums){
        Heap heap = new Heap();
        int currentNum = nums[0];
        for (int x=0; x<nums.length; x++){
            if(nums[x] > currentNum){
                currentNum = nums[x];
            }
            heap.insert(currentNum);
        }
        return heap.getHeap();

    }
}
