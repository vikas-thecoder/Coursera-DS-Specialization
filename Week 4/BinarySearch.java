/*
Task. The goal in this code problem is to implement the binary search algorithm.
Input Format. The first line of the input contains an integer 𝑛 and a sequence 𝑎0 < 𝑎1 < . . . < 𝑎𝑛 1
of 𝑛 pairwise distinct positive integers in increasing order. The next line contains an integer 𝑘 and 𝑘
positive integers 𝑏0, 𝑏1, . . . , 𝑏𝑘 1.
Constraints. 1 ≤ 𝑘 ≤ 105; 1 ≤ 𝑛 ≤ 3 · 104; 1 ≤ 𝑎𝑖 ≤ 109 for all 0 ≤ 𝑖 < 𝑛; 1 ≤ 𝑏𝑗 ≤ 109 for all 0 ≤ 𝑗 < 𝑘;
Output Format. For all 𝑖 from 0 to 𝑘 1, output an index 0 ≤ 𝑗 ≤ 𝑛 1 such that 𝑎𝑗 = 𝑏𝑖 or ∇1 if there is no such index.

Sample 1.
Input:
5 1 5 8 12 13
5 8 1 23 1 11
Output:
2 0 -1 0 -1
In this sample, we are given an increasing sequence 𝑎0 = 1, 𝑎1 = 5, 𝑎2 = 8, 𝑎3 = 12, 𝑎4 = 13 of length
five and five keys to search: 8, 1, 23, 1, 11. We see that 𝑎2 = 8 and 𝑎0 = 1, but the keys 23 and 11 do
not appear in the sequence 𝑎. For this reason, we output a sequence 2, 0, 1, 0, 1.
*/
import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length-1;
        //write your code here
        while(left<=right){
            int mid=left+((right-left)/2);
            if(a[mid]==x)
                return mid;
            else if(a[mid]>x)
                right=mid - 1;
            else
                left=mid + 1;
        }

        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
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
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
