/*
Problem Description

Task. Given 𝑛 gold bars, find the maximum weight of gold that fits into a bag of capacity 𝑊.
Input Format. The first line of the input contains the capacity 𝑊 of a knapsack and the number 𝑛 of bars
of gold. The next line contains 𝑛 integers 𝑤0, 𝑤1, . . . , 𝑤𝑛-1 defining the weights of the bars of gold.
Constraints. 1 ≤ 𝑊 ≤ 104; 1 ≤ 𝑛 ≤ 300; 0 ≤ 𝑤0, . . . , 𝑤𝑛-1 ≤ 105.

Output Format. Output the maximum weight of gold that fits into a knapsack of capacity 𝑊.

Sample 1.
Input:
10 3
1 4 8
Output:
9
Here, the sum of the weights of the first and the last bar is equal to 9.
*/
import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int[][] value = new int[W + 1][w.length + 1];
        for(int i = 1;i <= W;i++){
            for( int j = 1; j <= w.length;j++){
                value[i][j] = value[i][j - 1];
                if(w[j-1] <= i){
                    int temp = w[j-1] + value[i - w[j-1]][j-1];
                    if( temp > value[i][j])
                        value[i][j] = temp;
                }
            }
        }
        return value[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

