/*
Problem Description
Input Format. Integer money.
Output Format. The minimum number of coins with denominations 1, 3, 4 that changes money.
Constraints. 1 ≤ money ≤ 103.

Sample 1.
Input:
2
Output:
2
2 = 1 + 1.

Sample 2.
Input:
34
Output:
9
34 = 3 + 3 + 4 + 4 + 4 + 4 + 4 + 4 + 4.
*/
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here
        int[] change = new int[m+1];
        int[] coins = {1, 3, 4};
        for(int i = 1; i <= m; i++){
        	change[i] = Integer.MAX_VALUE;
        	for(int j = 0; j < 3; j++){
        		if(i >= coins[j]){
        			int temp = change[i-coins[j]] + 1;
        			if (temp < change[i])
        				change[i] = temp;
        		}
        	}
        }
        return change[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

