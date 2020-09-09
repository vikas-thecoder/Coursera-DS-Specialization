/*
Problem Description
Task. Given two integers 𝑛 and 𝑚, output 𝐹𝑛 mod 𝑚 (that is, the remainder of 𝐹𝑛 when divided by 𝑚).
Input Format. The input consists of two integers 𝑛 and 𝑚 given on the same line (separated by a space).
Constraints. 1 ≤ 𝑛 ≤ 1014, 2 ≤ 𝑚 ≤ 103.
Output Format. Output 𝐹𝑛 mod 𝑚.

Sample 1.
Input:
239 1000
Output:
161
𝐹239 mod 1 000 = 39 679 027 332 006 820 581 608 740 953 902 289 877 834 488 152 161 (mod 1 000) = 161.

Sample 2.
Input:
2816213588 239
Output:
151
𝐹2 816 213 588 does not fit into one page of this file, but 𝐹2 816 213 588 mod 239 = 151.
*/
import java.util.*;

public class FibonacciHuge {
   /*
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    */
    private static long getPisanoPeriod(long m){
        long a=0,b=1,c=0;

        for(int i=0;;i++){
            c=(a+b)%m;
            a=b;
            b=c;
            if(a==0 && b==1) return i+1;
        }
      
    }


    private static long getFibonacciHuge(long n,long m){

        long rem=n%getPisanoPeriod(m);
        long a=0,b=1,c=0;

        for(int i=0;i<rem;i++){
            c=(a+b)%m;
            a=b;
            b=c;        
        }

        return a;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        //System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(getFibonacciHuge(n,m));
    }
}

