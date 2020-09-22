/*
Problem Description
Task. The goal in this code problem is to check whether an input sequence contains a majority element.
Input Format. The first line contains an integer 𝑛, the next one contains a sequence of 𝑛 non-negative integers 𝑎0, 𝑎1, . . . , 𝑎𝑛 1.
Constraints. 1 ≤ 𝑛 ≤ 105; 0 ≤ 𝑎𝑖 ≤ 109 for all 0 ≤ 𝑖 < 𝑛.
Output Format. Output 1 if the sequence contains an element that appears strictly more than 𝑛/2 times, and 0 otherwise.
Sample 1.
Input:
5
2 3 9 2 2
Output:
12 is the majority element.

Sample 2.
Input:
4
1 2 3 4
Output:
0
There is no majority element in this sequence
*/
import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        //write your code here
        int count=1,index=1,majority=0;
        while(index<right){
            if(a[index]==a[majority])
                count+=1;
            else if(a[index]!=a[majority])
                count-=1;
            if(count==0){
                count=1;
                majority=index;
            }
            index++;
        }
        index=0;
        count=0;
        while(index<right){
            if(a[majority]==a[index])
                count++;
            index++;
        }

        if(count>(right/2))
            return a[majority];
        else
            return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

