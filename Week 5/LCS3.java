/*
Problem Description
Task. Given three sequences 𝐴 = (𝑎1, 𝑎2, . . . , 𝑎𝑛), 𝐵 = (𝑏1, 𝑏2, . . . , 𝑏𝑚), and 𝐶 = (𝑐1, 𝑐2, . . . , 𝑐𝑙), find the
length of their longest common subsequence, i.e., the largest non-negative integer 𝑝 such that there
exist indices 1 ≤ 𝑖1 < 𝑖2 < · · · < 𝑖𝑝 ≤ 𝑛, 1 ≤ 𝑗1 < 𝑗2 < · · · < 𝑗𝑝 ≤ 𝑚, 1 ≤ 𝑘1 < 𝑘2 < · · · < 𝑘𝑝 ≤ 𝑙 such
that 𝑎𝑖1 = 𝑏𝑗1 = 𝑐𝑘1, . . . , 𝑎𝑖𝑝 = 𝑏𝑗𝑝 = 𝑐𝑘𝑝
Input Format. First line: 𝑛. Second line: 𝑎1, 𝑎2, . . . , 𝑎𝑛. Third line: 𝑚. Fourth line: 𝑏1, 𝑏2, . . . , 𝑏𝑚. Fifth line:𝑙. Sixth line: 𝑐1, 𝑐2, . . . , 𝑐𝑙.
Constraints. 1 ≤ 𝑛, 𝑚, 𝑙 ≤ 100; 109 < 𝑎𝑖, 𝑏𝑖, 𝑐𝑖 < 109.
Output Format. Output 𝑝.

Sample 1.
Input:
3
1 2 3
3
2 1 3
3
1 3 5
Output:
2
A common subsequence of length 2 is (1, 3).

Sample 2.
Input:
5
8 3 2 1 7
7
8 2 1 3 8 10 7
6
6 8 3 1 4 7
Output:
3
One common subsequence of length 3 in this case is (8, 3, 7). Another one is (8, 1, 7).
*/
import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
        int[][][] lcs = new int[a.length + 1][b.length + 1][c.length + 1];
        for(int i = 0; i <= a.length ;i++){
            for(int j = 0; j<= b.length; j++){
                for(int k = 0; k <= c.length ; k++){
                    if(i==0 || j==0 || k==0)
                        lcs[i][j][k] = 0;
                    else if((a[i-1] == b[j-1]) && (b[j-1] == c[k-1]))
                        lcs[i][j][k] = lcs[i-1][j-1][k-1] + 1;
                    else
                        lcs[i][j][k] = Math.max(lcs[i][j][k-1],Math.max(lcs[i][j-1][k],lcs[i-1][j][k]));
                }
            }
        }
        return lcs[a.length][b.length][c.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

