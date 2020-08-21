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

