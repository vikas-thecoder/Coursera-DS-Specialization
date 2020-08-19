/*
Problem Description
Task. Given an integer 𝑛, find the last digit of the 𝑛th Fibonacci number 𝐹𝑛 (that is, 𝐹𝑛 mod 10).
Input Format. The input consists of a single integer 𝑛.
Constraints. 0 ≤ 𝑛 ≤ 107.
Output Format. Output the last digit of 𝐹𝑛.
Sample 1.
Input:
3
Output:
2𝐹3 = 2.
Sample 2.
Input:
331
Output:
9𝐹331 = 668 996 615 388 005 031 531 000 081 241 745 415 306 766 517 246 774 551 964 595 292 186 469.
Sample 3.
Input:
327305
Output:
5𝐹327305 does not fit into one line of this pdf, but its last digit is equal to 5.

*/

import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigit(int n) {
        

        int previous = 0;
        int current  = 1;
        int c=0;
        for (int i = 0; i <n; ++i) {
            c=(previous+current)%10;
            previous=current;
            current=c;

        }
           

        return previous;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}

