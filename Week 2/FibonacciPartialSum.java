import java.util.*;

public class FibonacciPartialSum {
    /*
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }
    */
    private static void multiply(int[][] p,int[][] q){
       int a=(p[0][0] * q[0][0] + p[0][1] * q[1][0]);
       int b=(p[0][0] * q[0][1] + p[0][1] * q[1][1]);
       int c=(p[1][0] * q[0][0] + p[1][1] * q[1][0]);
       int d=(p[1][0] * q[0][1] + p[1][1] * q[1][1]);

        p[0][0]= a%10;
        p[0][1]= b%10;
        p[1][0]= c%10;
        p[1][1]= d%10;
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


    private static long getFibonacciPartialSum(long from,long to){

       return ((getFibonacci(to+2)+10) -getFibonacci(from+1))%10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        //System.out.println(getFibonacciPartialSumNaive(from, to));
        System.out.println(getFibonacciPartialSum(from,to));

    }
}

