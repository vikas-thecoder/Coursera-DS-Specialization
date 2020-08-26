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

