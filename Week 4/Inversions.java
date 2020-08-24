/*
Problem Description
Task. The goal in this problem is to count the number of inversions of a given sequence.
Input Format. The first line contains an integer 𝑛, the next one contains a sequence of integers 𝑎0, 𝑎1, . . . , 𝑎𝑛 1.
Constraints. 1 ≤ 𝑛 ≤ 105, 1 ≤ 𝑎𝑖 ≤ 109 for all 0 ≤ 𝑖 < 𝑛.
Output Format. Output the number of inversions in the sequence.

Sample 1.
Input:
5
2 3 9 2 9
Output:
2
The two inversions here are (1, 3) (𝑎1 = 3 > 2 = 𝑎3) and (2, 3) (𝑎2 = 9 > 2 = 𝑎3).
*/
import java.util.*;

public class Inversions {
    private static long merge(int[] a, int left, int mid,int right){
        int lsize = mid - left, rsize = right - mid ;
        long inv = 0;
        int[] larray = new int[lsize];
        int[] rarray = new int[rsize];
        
        for( int k = 0;k < lsize;k++){
            larray[k] = a[left + k];
        }

        for(int k = 0;k < rsize;k++ ){
            rarray[k] = a[mid + k];
        }

        int k = left;
        int i = 0 ,j = 0;
        while((i < lsize) && (j < rsize)){
            if(larray[i] <= rarray[j]){
                a[k++] = larray[i++];
            }
            else{
               // System.out.println(larray[i])
                inv+=lsize-i;
                a[k++] = rarray[j++];
            }
        }
        while(i < lsize)
            a[k++] = larray[i++];

        while(j < rsize)
            a[k++] = rarray[j++];
        return inv;
    }

    private static long getNumberOfInversions(int[] a, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = left +((right - left) / 2);
        numberOfInversions += getNumberOfInversions(a, left, ave);
        numberOfInversions += getNumberOfInversions(a, ave, right);
        //write your code here
        numberOfInversions += merge(a ,left ,ave ,right );
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long inv=getNumberOfInversions(a, 0, a.length);
        System.out.println(inv);
    }
}

