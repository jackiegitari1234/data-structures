package com.patterns.problems.fibonacci;

public class FibonacciRecu {
//    public static Integer[] memo = new Integer[100];

    public static int fiboRecursion(int n){
        if (n==1 || n==0) return n;
        return fiboRecursion(n-1) + fiboRecursion(n-2);
    }

    //top down
    public static int fiboMemoization(int n){
         Integer[] memo = new Integer[n+1];

        if (memo[n] != null ){
            return memo[n];
        }
        if (n==1 || n==0) return n;
        memo[n] = fiboMemoization(n-1) + fiboMemoization(n-2);
        return memo[n];

    }

    //bottom up
    public static int fiboMemoization2(int n){
        Integer[] memo = new Integer[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i-1] +memo[i-2];
        }
        return memo[n];
    }


        public static void main(String[] args) {

        System.out.println(fiboMemoization2(30));

    }
}
