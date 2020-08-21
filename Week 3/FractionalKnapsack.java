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
