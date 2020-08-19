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

