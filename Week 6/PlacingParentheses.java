import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
    long[] digit = new long[exp.length()/2 + 1];
    char[] operator = new char[digit.length - 1];
    
    for( int i = 0; i < exp.length();i++){
        if( i % 2 == 0)
            digit[i/2] = exp.charAt(i) - '0';
        else
            operator[(i+1)/2 - 1] = exp.charAt(i);
    }

    long[][] min = new long[digit.length][digit.length];
    long[][] max = new long[digit.length][digit.length];

    for( int i = 0;i < digit.length; i++){
        max[i][i] = digit[i];
        min[i][i] = digit[i];
    }

    for( int s = 0; s < digit.length;s++){
        for( int i = 0; i < digit.length - s - 1; i++){
            int j = i + s + 1;
            long tmin = Long.MAX_VALUE;
            long tmax = Long.MIN_VALUE;
            for( int k = i; k < j;k++){
                long a = eval(max[i][k] , max[k+1][j] ,operator[k]);
                long b = eval(max[i][k] , min[k+1][j] ,operator[k]);
                long c = eval(min[i][k] , max[k+1][j] ,operator[k]);
                long d = eval(min[i][k] , min[k+1][j] ,operator[k]);

                tmin = Math.min(Math.min(Math.min(a,b),Math.min(c,d)),tmin);
                tmax = Math.max(Math.max(Math.max(a,b),Math.max(c,d)),tmax);
            }
            min[i][j] = tmin;
            max[i][j] = tmax;
        }
    }
      return max[0][digit.length - 1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

