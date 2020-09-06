/*
Problem Description
Input Format. The first line contains an integer 𝑛. The second line contains integers 𝑣1, 𝑣2, . . . , 𝑣𝑛 separated
by spaces.
Constraints. 1 ≤ 𝑛 ≤ 20, 1 ≤ 𝑣𝑖 ≤ 30 for all 𝑖.
Output Format. Output 1, if it possible to partition 𝑣1, 𝑣2, . . . , 𝑣𝑛 into three subsets with equal sums, and 0 otherwise.

Sample 1.
Input:
4
3 3 3 3
Output:
0

Sample 2.
Input:
1
40
Output:
0
*/
import java.util.*;
import java.io.*;

public class Partition3 {
    private static boolean util(int k,int sum,int cursum,int[] A,boolean[] used,int curind){
        if(k == 0)
            return true;
        if(cursum == sum)
            return util(k-1 ,sum ,0 ,A ,used ,0);
        for( int i = curind; i < A.length; i++){
            if( !used[i] && cursum + A[i] <= sum){
                used[i] = true;

                if( util(k, sum, cursum + A[i],A ,used ,i + 1))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }
    private static int partition3(int[] A) {
        //write your code here
        if( A.length < 3)
            return 0;

        int sum = 0;
        boolean[] used = new boolean[A.length];
        for(int i = 0;i < A.length;i++){
            sum = sum + A[i];
        }

        if( sum % 3 != 0)
            return 0;
        else 
            return (util(3 ,sum / 3 ,0 ,A ,used ,0 )) ?1 : 0;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

