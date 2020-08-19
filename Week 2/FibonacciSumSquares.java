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

