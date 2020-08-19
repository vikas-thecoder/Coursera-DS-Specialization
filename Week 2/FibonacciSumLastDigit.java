/*
Problem Description
Task. Given an integer 𝑛, find the last digit of the sum 𝐹0 + 𝐹1 + · · · + 𝐹𝑛.
Input Format. The input consists of a single integer 𝑛.
Constraints. 0 ≤ 𝑛 ≤ 1014
.
Output Format. Output the last digit of 𝐹0 + 𝐹1 + · · · + 𝐹𝑛.
Sample 1.
Input:
3
Output:
4
𝐹0 + 𝐹1 + 𝐹2 + 𝐹3 = 0 + 1 + 1 + 2 = 4.

Sample 2.
Input:
100
Output:
5
The sum is equal to 927 372 692 193 078 999 175, the last digit is 5.
*/
import java.util.*;

public class FibonacciSumLastDigit {
/*
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
*/ 
    /*  "Less Effecient"
        static int[] f = new int[1000];
        static{
        f[1]=1;
        f[2]=1;  }

    private static int getFibonacci(long n){
        
        if(n==0){
            return 0;}

        if(n==1 || n==2){
            return f[(int)n];}

        if(n<=1000 && f[(int)n]!=0){
            return f[(int)n];}

        long rem=((n&1)==1)?((n+1)/2):(n/2);

        int x=getFibonacci(rem)%100;
        int y=getFibonacci(rem-1)%100;

        if((n&1)==1){
            int temp=((x*x)+(y*y))%100;

            if(n<=1000) 
                 f[(int)n]=temp;

            return temp;
        }
        else{
            int temp=(((2*y)+x)*x)%100;

            if(n<=1000)
                f[(int)n]=temp;

            return temp;
        }
     
        

    }

    private static long getFibonacciSum(long n){
        
        return (getFibonacci(n+2)-1)%10;
    }
*/

    private static void multiply(int[][] p,int[][] q){
       int a=(p[0][0] * q[0][0] + p[0][1] * q[1][0]);
       int b=(p[0][0] * q[0][1] + p[0][1] * q[1][1]);
       int c=(p[1][0] * q[0][0] + p[1][1] * q[1][0]);
       int d=(p[1][0] * q[0][1] + p[1][1] * q[1][1]);

        p[0][0]= a%100;
        p[0][1]= b%100;
        p[1][0]= c%100;
        p[1][1]= d%100;
    }

    private static void power(int[][] f,long pow){
        if(pow==0 || pow==1)
            return;

        power(f,pow/2);
        multiply(f,f);
        if((pow&1)==1)
            multiply(f,new int[][]{{1,1},{1,0}});

    }



    private static int getFibonacci(long  n){
    
        if(n<2)
            return (int)n;

        if(n==2)
            return 1;

        int[][] f={{1,1},{1,0}};

        power(f,n-1);
       
        return f[0][0];
    }


    private static long getFibonacciSum(long n){

       return ( getFibonacci(n+2) - 1) % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
       // long s = getFibonacciSumNaive(n);
        long s=getFibonacciSum(n);
        System.out.println(s);
    }
}

