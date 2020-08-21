/*
Problem Description
Task. Compose the largest number out of a set of integers.
Input Format. The first line of the input contains an integer 𝑛. The second line contains integers 𝑎1, 𝑎2, . . . , 𝑎𝑛.
Constraints. 1 ≤ 𝑛 ≤ 100; 1 ≤ 𝑎𝑖 ≤ 103 for all 1 ≤ 𝑖 ≤ 𝑛.

Output Format. Output the largest number that can be composed out of 𝑎1, 𝑎2, . . . , 𝑎𝑛.

Sample 1.
Input:
2
21 2
Output:
221
Note that in this case the above algorithm also returns an incorrect answer 212.

Sample 2.
Input:
5
9 4 6 1 9
Output:
99641
In this case, the input consists of single-digit numbers only, so the algorithm above computes the right answer.

Sample 3.
Input:
3
23 39 92
Output:
923923
As a coincidence, for this input the above algorithm produces the right result, though the input does
not have any single-digit numbers
*/
import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        ArrayList<String> nums=new ArrayList<>();
        String result = "";

        for (int i = 0; i < a.length; i++) {
            nums.add(a[i]);
            }

        while(nums.size()!=0){
            String max=nums.get(0);

            for(int i=1;i<nums.size();i++){
                String c=max+nums.get(i);
                String d=nums.get(i)+max;

                if(c.compareTo(d)<0)
                    max=nums.get(i);
            }
            result+=max;
            nums.remove(max);
        }
        
        return result;
    

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

