package com.patterns.problems.cases.binary;

//& (bitwise AND)
//| (bitwise OR)
//^ (bitwise XOR)
// << (left shift)
//>> (right shift)
//~ (bitwise NOT) takes one number and inverts all bits of it.
public class SumWithoutOperator {

    public int getDifference(int a, int b) {
        // Compute -b using two's complement
//        b = ~b + 1;

        return getSum(a, getSum(~b, 1));
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        SumWithoutOperator solution = new SumWithoutOperator();
        System.out.println("sum " +solution.getSum(5, 3));  // Output: 8
        System.out.println(solution.getDifference(5, 3));
//        System.out.println(solution.getSum(-2, -3)); // Output: -5
    }
}

