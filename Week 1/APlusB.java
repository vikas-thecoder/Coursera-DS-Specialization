/*
                                                     Sum of Two Digits Problem
Compute the sum of two single digit numbers.
Input: Two single digit numbers.
Output: The sum of these numbers.
2 + 3 = 5
We start from this ridiculously simple problem to show you the pipeline of reading the problem statement, designing an algorithm, implementing it, testing and debugging your program, and submitting it to the grading system.
Input format. Integers a and b on the same line (separated by a space).
Output format. The sum of a and b.
Constraints. 0 ≤ a,b ≤ 9.
Sample.
Input:
9 7
Output:
16

*/


import java.util.Scanner;

class APlusB {
    static int sumOfTwoDigits(int first_digit, int second_digit) {
        return first_digit + second_digit;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(sumOfTwoDigits(a, b));
    }
}
