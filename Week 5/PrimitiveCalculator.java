/*
Problem Description
Task. Given an integer 𝑛, compute the minimum number of operations needed to obtain the number 𝑛 starting from the number 1.
Input Format. The input consists of a single integer 1 ≤ 𝑛 ≤ 106.
Output Format. In the first line, output the minimum number 𝑘 of operations needed to get 𝑛 from 1.
In the second line output a sequence of intermediate numbers. That is, the second line should contain
positive integers 𝑎0, 𝑎2, . . . , 𝑎𝑘‖1 such that 𝑎0 = 1, 𝑎𝑘‖1 = 𝑛 and for all 0 ≤ 𝑖 < 𝑘 ‖ 1, 𝑎𝑖+1 is equal to either 𝑎𝑖 + 1, 2𝑎𝑖 , or 3𝑎𝑖.
If there are many such sequences, output any one of them.

Sample 1.
Input:
1
Output:
0
1

Sample 2.
Input:
5
Output:
3
1 2 4 5
Here, we first multiply 1 by 2 two times and then add 1. Another possibility is to first multiply by 3
and then add 1 two times. Hence “1 3 4 5” is also a valid output in this case.

Sample 3.
Input:
96234
Output:
14
1 3 9 10 11 22 66 198 594 1782 5346 16038 16039 32078 96234
Again, another valid output in this case is “1 3 9 10 11 33 99 297 891 2673 8019 16038 16039 48117
96234”.
*/
import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] operation = new int[n+1];
        for( int i=2; i < operation.length; i++){
            int min1 = operation[i-1] + 1;
            int min2 = Integer.MAX_VALUE;
            int min3 = Integer.MAX_VALUE;
            if(i % 2 == 0)
                min2 = operation[i/2] + 1;
            if(i % 3 == 0)
                min3 = operation[i/3] + 1;
            operation[i] = Math.min(min1 , Math.min(min2 , min3));

        } 
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if ((n % 3 == 0) && ( operation[n] == operation[n/3] + 1 )) {
                n /= 3;
            } else
            if ((n % 2 == 0) && ( operation[n] == operation[n/2] + 1)) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

