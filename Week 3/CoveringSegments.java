/*
Problem Description
Task. Given a set of 𝑛 segments {[𝑎0, 𝑏0], [𝑎1, 𝑏1], . . . , [𝑎𝑛 1, 𝑏𝑛 1]} with integer coordinates on a line, find
the minimum number 𝑚 of points such that each segment contains at least one point. That is, find a
set of integers 𝑋 of the minimum size such that for any segment [𝑎𝑖 , 𝑏𝑖] there is a point 𝑥 ∈ 𝑋 such that 𝑎𝑖 ≤ 𝑥 ≤ 𝑏𝑖.

Input Format. The first line of the input contains the number 𝑛 of segments. Each of the following 𝑛 lines
contains two integers 𝑎𝑖 and 𝑏𝑖 (separated by a space) defining the coordinates of endpoints of the 𝑖-th segment.
Constraints. 1 ≤ 𝑛 ≤ 100; 0 ≤ 𝑎𝑖 ≤ 𝑏𝑖 ≤ 109 for all 0 ≤ 𝑖 < 𝑛.

Output Format. Output the minimum number 𝑚 of points on the first line and the integer coordinates
of 𝑚 points (separated by spaces) on the second line. You can output the points in any order. If there
are many such sets of points, you can output any set. (It is not difficult to see that there always exist
a set of points of the minimum size such that all the coordinates of the points are integers.)

Sample 1.
Input:
3
1 3
2 5
3 6
Output:
13
In this sample, we have three segments: [1, 3], [2, 5], [3, 6] (of length 2, 3, 3 respectively). All of them
contain the point with coordinate 3: 1 ≤ 3 ≤ 3, 2 ≤ 3 ≤ 5, 3 ≤ 3 ≤ 6. 

Sample 2.
Input:
4
4 7
1 3
2 5
5 6
Output:
2
3 6
The second and the third segments contain the point with coordinate 3 while the first and the fourth
segments contain the point with coordinate 6. All the four segments cannot be covered by a single
point, since the segments [1, 3] and [5, 6] are disjoint.
*/
import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        ArrayList<Segment> points=new ArrayList<>();
        ArrayList<Integer> result=new ArrayList<>();
        for (int i = 0; i < segments.length; i++) {
                points.add(segments[i]);
        }
        while(points.size()!=0){
            int minEnd=Integer.MAX_VALUE;
            for(Segment s:points){
                if(s.end<minEnd)
                    minEnd=s.end;
            }
            result.add(minEnd);

            ListIterator<Segment> iter=points.listIterator();


            while(iter.hasNext()){
                Segment s=iter.next();
                if(s.start<=minEnd && minEnd<=s.end)
                    iter.remove();
            }

        }
        int[] res=new int[result.size()];
        for(int i=0;i<res.length;i++)
            res[i]=result.get(i);

        return res;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
