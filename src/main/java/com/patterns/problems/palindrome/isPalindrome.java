package com.patterns.problems.palindrome;

import java.util.HashMap;
import java.util.Map;

//two pointer
public class isPalindrome {


    public static  boolean checkIfPalindrome(String input){
        int x =0;
        int y = input.length()-1;
        while ( x< input.length() && y> input.length()/2 ){
            if (y==x){
                return true;
            }
            if (input.charAt(x) != input.charAt(y)){
                return false;
            }
            x++;
            y--;


        }
        return true;

    }


    public static void main(String[] args) {
//        String S = "dd";
//        String S = "fknfkn"; //2
        String S = "RACECAR";
//        String S = "aaaabc"; //2
        System.out.println("Is palindromes: " + checkIfPalindrome(S));
    }
}
