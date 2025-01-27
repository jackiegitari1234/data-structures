package com.patterns.problems.cases;


import org.junit.Test;

/**
 * Check only upto its sqrt
 *
 */
public class Prime {


    boolean getPrime(int n){
        if (n <= 1) {
            return false;
        }

        if (n <= 3) {
            return true; // 2 and 3 are prime numbers
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false; // Eliminate even numbers and multiples of 3
        }

        //The loop starts from 5 and skips even numbers and multiples of 3 by incrementing x by 6.
        for (int x = 5; x * x <= n; x += 6) {
            if (n % x == 0 || n % (x + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public  void testMethod() {

        int number = 9;
        System.out.println(number +" is prime : " + getPrime(number));
    }
}
