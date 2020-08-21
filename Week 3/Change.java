/*
Problem Description
Task. The goal in this problem is to find the minimum number of coins needed to change the input value
(an integer) into coins with denominations 1, 5, and 10.
Input Format. The input consists of a single integer 𝑚.
Constraints. 1 ≤ 𝑚 ≤ 103.
Output Format. Output the minimum number of coins with denominations 1, 5, 10 that changes 𝑚.

Sample 1.
Input:
2
Output:
2
2 = 1 + 1
.
Sample 2.
Input:
28
Output:
6
28 = 10 + 10 + 5 + 1 + 1 + 1.
*/
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int n=0;
        while(m>0){
        	if(m>=10)
        		m-=10;
        	else if(m>=5)
        		m-=5;
        	else
        		m-=1;
        	n++;

        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

