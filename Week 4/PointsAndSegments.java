/*
Problem Description
Task. You are given a set of points on a line and a set of segments on a line. The goal is to compute, for
each point, the number of segments that contain this point.
Input Format. The first line contains two non-negative integers 𝑠 and 𝑝 defining the number of segments
and the number of points on a line, respectively. The next 𝑠 lines contain two integers 𝑎𝑖, 𝑏𝑖 defining the 𝑖-th segment [𝑎𝑖, 𝑏𝑖].
The next line contains 𝑝 integers defining points 𝑥1, 𝑥2, . . . , 𝑥𝑝.
Constraints. 1 ≤ 𝑠, 𝑝 ≤ 50000; 108 ≤ 𝑎𝑖 ≤ 𝑏𝑖 ≤ 108 for all 0 ≤ 𝑖 < 𝑠; 108 ≤ 𝑥𝑗 ≤ 108 for all 0 ≤ 𝑗 < 𝑝.
Output Format. Output 𝑝 non-negative integers 𝑘0, 𝑘1, . . . , 𝑘𝑝 1 where 𝑘𝑖 is the number of segments which
contain 𝑥𝑖. More formally, 𝑘𝑖 = |{𝑗 : 𝑎𝑗 ≤ 𝑥𝑖 ≤ 𝑏𝑗}| .

Sample 1.
Input:
2 3
0 5
7 10
1 6 11
Output:
1 0 0
Here, we have two segments and three points. The first point lies only in the first segment while the
remaining two points are outside of all the given segments.

Sample 2.
Input:
1 3
-10 10
-100 100 0
Output:
0 0 1

Sample 3.
Input:
3 2
0 5
-3 2
7 10
1 6
Output:
2 0
*/
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

