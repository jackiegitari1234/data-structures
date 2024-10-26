package com.patterns.problems.cases;

import org.junit.jupiter.api.Test;


public class Prime {

    Boolean getPrime(int n){
        double bb = Math.sqrt(n);
        for(int x=2; x<= Math.sqrt(n); x++){
            if(n%x == 0) {
                return true;
            }
        }

        return false;
    }

    Boolean getPrime2(int n){
        for(int x=2; x<n; x++){
            if(n%x == 0) {
                return true;
            }
        }

        return false;
    }

    @Test
    public  void testMethod() {

        System.out.println("number is prime : " + getPrime(4));
    }
}
