/*
Problem Description
Task. Given two sequences 𝐴 = (𝑎1, 𝑎2, . . . , 𝑎𝑛) and 𝐵 = (𝑏1, 𝑏2, . . . , 𝑏𝑚), find the length of their longest
common subsequence, i.e., the largest non-negative integer 𝑝 such that there exist indices 1 ≤ 𝑖1 < 𝑖2 < · · · < 𝑖𝑝 ≤ 𝑛 and 1 ≤ 𝑗1 < 𝑗2 < · · · < 𝑗𝑝 ≤ 𝑚, such that 𝑎𝑖1 = 𝑏𝑗1, . . . , 𝑎𝑖𝑝 = 𝑏𝑗𝑝 .
Input Format. First line: 𝑛. Second line: 𝑎1, 𝑎2, . . . , 𝑎𝑛. Third line: 𝑚. Fourth line: 𝑏1, 𝑏2, . . . , 𝑏𝑚.
Constraints. 1 ≤ 𝑛, 𝑚 ≤ 100; 109 < 𝑎𝑖, 𝑏𝑖 < 109.
Output Format. Output 𝑝.

Sample 1.
Input:
3
2 7 5
2
2 5
Output:
2
A common subsequence of length 2 is (2, 5).

Sample 2.
Input:
174
1 2 3 4
Output:
0
The two sequences do not share elements.

Sample 3.
Input:
4
2 7 8 3
4
5 2 8 7
Output:
2
*/
import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int lena = a.length;
        int lenb = b.length;
        int[][] lcs = new int[lena+1][lenb+1];
        for(int i = 1 ;i <= lena ; i++){
            for(int j = 1 ;j <= lenb ;j++){
                if(a[i-1] == b[j-1])
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i][j-1],lcs[i-1][j]);
           }
        }

        return lcs[lena][lenb];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

