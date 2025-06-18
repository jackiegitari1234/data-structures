package com.patterns.problems.cases.binary;

//Given a positive integer n, write a function that returns the number of
//set bits
// in its binary representation (also known as the Hamming weight).
//
//
//
// Divide by 2: 29 / 2 = 14 with a remainder of 1
// Divide by 2: 14 / 2 = 7 with a remainder of 0
// Divide by 2: 7 / 2 = 3 with a remainder of 1
// Divide by 2: 3 / 2 = 1 with a remainder of 1
// Divide by 2: 1 / 2 = 0 with a remainder of 1
// The binary representation of 29 is 11101, which contains 4 set bits.
//
//
//11101 to decimal = (1 * 2^4) + (1 * 2^3) + (1 * 2^2) + (0 * 2^1) + (1 * 2^0) = 16 + 8 + 4 + 0 + 1 = 29
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
