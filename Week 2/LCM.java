/*
Problem Description
Task. Given two integers 𝑎 and 𝑏, find their least common multiple.
Input Format. The two integers 𝑎 and 𝑏 are given in the same line separated by space.
Constraints. 1 ≤ 𝑎, 𝑏 ≤ 107.
Output Format. Output the least common multiple of 𝑎 and 𝑏.
Sample 1.
Input:
6 8
Output:
24
Among all the positive integers that are divisible by both 6 and 8 (e.g., 48, 480, 24), 24 is the smallest
one.

Sample 2.
Input:
761457 614573
Output:
467970912861
*/
import java.util.*;

public class LCM {

  private static long gcd(int a,int b){
    if(b==0)
      return a;

    return gcd(b,a%b);
  }
  private static long lcm(int a, int b) {

    return ((long)a * b)/gcd(a,b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  
  }
}
