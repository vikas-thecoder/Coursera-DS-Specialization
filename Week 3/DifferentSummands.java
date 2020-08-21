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

