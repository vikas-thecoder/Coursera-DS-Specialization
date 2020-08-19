/*
Task. Given an integer 𝑛, find the 𝑛th Fibonacci number 𝐹𝑛.
Input Format. The input consists of a single integer 𝑛.
Constraints. 0 ≤ 𝑛 ≤ 45.
Output Format. Output 𝐹𝑛.
Sample 1.
Input:
10
Output:
55
𝐹10 = 55.
*/
import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
  long[] fib= new long[n+2];
  fib[0]=0;
  fib[1]=1;
  for(int i=2;i<=n;i++){
    fib[i]=fib[i-1]+fib[i-2];}
  return fib[n];

  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(calc_fib(n));
  }
}
