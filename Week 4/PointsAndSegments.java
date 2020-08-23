import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        int[] pointscopy = new int[points.length];
        HashMap<Integer,Integer> countmap = new HashMap<>();

        for(int i=0;i<points.length;i++){
            pointscopy[i] = points[i];
            countmap.put(points[i],0);
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        Arrays.sort(points);
        int count = 0;
        int si = 0;
        int ei = 0;

        for(int i=0;i<points.length;i++){
            while(( si < starts.length ) && (starts[si] <= points[i]) ){
                count++;
                si++;
            }
            while(( ei < ends.length) && ( ends[ei]) < points[i] ){
                count--;
                ei++;
            }
            countmap.replace(points[i],count);
        }


        for(int i=0;i<points.length;i++){
            cnt[i]=countmap.get(pointscopy[i]);
        }

        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        //int[] cnt = naiveCountSegments(starts, ends, points);
        int[] cnt = fastCountSegments(starts ,ends ,points );
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

