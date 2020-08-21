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
 
