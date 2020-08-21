/*
Problem Description
Task. The goal of this problem is to represent a given positive integer 𝑛 as a sum of as many pairwise
distinct positive integers as possible. That is, to find the maximum 𝑘 such that 𝑛 can be written as
𝑎1 + 𝑎2 + · · · + 𝑎𝑘 where 𝑎1, . . . , 𝑎𝑘 are positive integers and 𝑎𝑖 = 𝑎𝑗 for all 1 ≤ 𝑖 < 𝑗 ≤ 𝑘.

Input Format. The input consists of a single integer 𝑛.

Constraints. 1 ≤ 𝑛 ≤ 109.

Output Format. In the first line, output the maximum number 𝑘 such that 𝑛 can be represented as a sum
of 𝑘 pairwise distinct positive integers. In the second line, output 𝑘 pairwise distinct positive integers
that sum up to 𝑛 (if there are many such representations, output any of them).

Sample 1.
Input:
6
Output:
3
1 2 3

Sample 2.
Input:
8
Output:
3
1 2 5

Sample 3.
Input:
2
Output:
12
*/
import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int sum=0;
        int i=1;
        while(sum!=n){
            if(n-(sum+i)==0){
                summands.add(i);
                break;
            }
            else if(i<(n-(sum+i))){
                sum=sum+i;
                summands.add(i);
            }

            i++;
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        int sum=0;
        for (Integer summand : summands) {
            sum=sum+summand;
            System.out.print(summand + " ");
        }
        System.out.print("sum"+sum);
    }
}

