/*
Last Digit of the Sum of Squares of Fibonacci Numbers
Problem Description
Task. Compute the last digit of 𝐹20 + 𝐹21 + · · · + 𝐹2𝑛.
Input Format. Integer 𝑛.
Constraints. 0 ≤ 𝑛 ≤ 1014
Output Format. The last digit of 𝐹20 + 𝐹21 + · · · + 𝐹2𝑛.
Sample 1.
Input:
7
Output:
3
𝐹20 + 𝐹21 + · · · + 𝐹27 = 0 + 1 + 1 + 4 + 9 + 25 + 64 + 169 = 273.

Sample 2.
Input:
73
Output:
1
𝐹20 + · · · + 𝐹2
73 = 1 052 478 208 141 359 608 061 842 155 201.

Sample 3.
Input:
1234567890
Output:
0
*/
import java.util.*;

public class FibonacciSumSquares {
   /*
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }
    */

    private static void getMultiply(int[][] f,int[][] q){
        int a= f[0][0] * q[0][0] + f[0][1] * q[1][0];
        int b= f[0][0] * q[0][1] + f[0][1] * q[1][1];
        int c= f[1][0] * q[0][0] + f[1][1] * q[1][0];
        int d= f[1][0] * q[0][1] + f[1][1] * q[1][1];

        f[0][0] = a % 100;
        f[0][1] = b % 100;
        f[1][0] = c % 100;
        f[1][1] = d % 100;
    }
    
    private static void getPower(int[][] f,long n){

        if(n <2) return;

        getPower(f,n/2);
        getMultiply(f,f);

        if((n&1)==1)
           getMultiply(f,new int[][]{{1,1},{1,0}});

      } 

    private static long getFibonacciSumSquares(long n){
        int[][] f={{1,1},{1,0}};

        if(n<2)  return n;

    
        getPower(f,n);

        return (f[0][0] * f[0][1]) % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
      //  long s = getFibonacciSumSquaresNaive(n);
        System.out.println(getFibonacciSumSquares(n));
    }
}

