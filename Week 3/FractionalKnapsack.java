/*
Problem Description
Task. The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
Input Format. The first line of the input contains the number 𝑛 of items and the capacity 𝑊 of a knapsack.
The next 𝑛 lines define the values and weights of the items. The 𝑖-th line contains integers 𝑣𝑖 and 𝑤𝑖—the
value and the weight of 𝑖-th item, respectively.

Constraints. 1 ≤ 𝑛 ≤ 103, 0 ≤ 𝑊 ≤ 2 · 106; 0 ≤ 𝑣𝑖 ≤ 2 · 106, 0 < 𝑤𝑖 ≤ 2 · 106
for all 1 ≤ 𝑖 ≤ 𝑛. All the
numbers are integers.

Output Format. Output the maximal value of fractions of items that fit into the knapsack. The absolute
value of the difference between the answer of your program and the optimal value should be at most
10**-3
. To ensure this, output your answer with at least four digits after the decimal point (otherwise
your answer, while being computed correctly, can turn out to be wrong because of rounding issues).

Sample 1.
Input:
3 50
60 20
100 50
120 30
Output:
180.0000
To achieve the value 180, we take the first item and the third item into the bag.

Sample 2.
Input:
1 10
500 30
Output:
166.6667
Here, we just take one third of the only available item.
*/
import java.util.Scanner;
import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        SortedMap<Double,Integer> sortedValuePerWeight=new TreeMap<Double,Integer>(new Comparator(){
            public int compare(Object o1,Object o2){
                Double a=(Double)o1;
                Double b=(Double)o2;

                return b.compareTo(a);
            }
        });

        for(int i=0;i<values.length;i++){
            sortedValuePerWeight.put((double)values[i]/weights[i],i);
        }

    while(capacity!=0 && sortedValuePerWeight.size()!=0){
        Double a=sortedValuePerWeight.firstKey();
        Integer i=sortedValuePerWeight.get(a);
        int temp=Math.min(weights[i],capacity);
        value+=temp*a;
        capacity-=temp;
        sortedValuePerWeight.remove(a);
        
    }

        return Math.round(value*10000d)/10000d;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
