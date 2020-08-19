/*
Problem Description
Task. Given two integers 𝑎 and 𝑏, find their greatest common divisor.
Input Format. The two integers 𝑎, 𝑏 are given in the same line separated by space.
Constraints. 1 ≤ 𝑎, 𝑏 ≤ 2 · 109.
Output Format. Output GCD(𝑎, 𝑏).
Sample 1.
Input:
18 35
Output:
1
18 and 35 do not have common non-trivial divisors.

Sample 2.
Input:
28851538 1183019
Output:
17657
28851538 = 17657 · 1634, 1183019 = 17657 · 67.
*/
import java.util.*;

public class GCD {
  private static int gcd(int a, int b) {
    
    if(b==0)
        return a;

    return gcd(b,a%b);

  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
