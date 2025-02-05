package com.patterns.problems.cases.binary;

public class HammingWeight {

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            int var = n & 1;
            count += n & 1; // Check if the last bit is set
            n >>= 1; // Shift right to process the next bit
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 29; // Example input
        System.out.println("Number of set bits: " + countSetBits(n)); // Output: 4
    }
    
}
