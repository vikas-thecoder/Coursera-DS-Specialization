/*

Maximum Pairwise Product Problem
Find the maximum product of two distinct num￾bers in a sequence of non-negative integers.
Input: A sequence of non-negative integers.
Output: The maximum value that can be obtained by multiplying
two different elements from the sequence.
5 6 2 7 4 5 30 10 35 20
6 30 12 42 24
2 10 12 14 8 7 35 42 14 28
4 20 24 8 28
Given a sequence of non-negative integers a1,...,an, compute max 1≤i,j≤n ai · aj .
Note that i and j should be different, though it may be the case that ai = aj.
Input format. The first line contains an integer n. The next line contains n non-negative integers a1 ,...,an (separated by spaces).
Output format. The maximum pairwise product.
Constraints. 2 ≤ n ≤ 2 · 105 ; 0 ≤ a1 ,...,an ≤ 2 · 105.
Sample 1.
Input:
3
1 2 3
Output:
6
10
Sample 2.
Input:
10
7 5 14 2 8 8 10 1 2 3
Output:
140

*/

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        long n = numbers.length;
        long max1=Integer.MIN_VALUE;
        long max2=Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
           if(numbers[i]>max1){
            max2=max1;
            max1=numbers[i];
           }
           else if(numbers[i]>max2){
            max2=numbers[i];
           }

        }
        max_product=max1*max2;
        return max_product;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
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
