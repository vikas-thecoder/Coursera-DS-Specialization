/*
Problem Description
Task. Given 𝑛 points on a plane, find the smallest distance between a pair of two (different) points. Recall
that the distance between points (𝑥1, 𝑦1) and (𝑥2, 𝑦2) is equal to √︀(𝑥1 𝑥2)2 + (𝑦1 𝑦2)2.
Input Format. The first line contains the number 𝑛 of points. Each of the following 𝑛 lines defines a point (𝑥𝑖, 𝑦𝑖). 
Constraints. 2 ≤ 𝑛 ≤ 105; 109 ≤ 𝑥𝑖
, 𝑦𝑖 ≤ 109 are integers.
Output Format. Output the minimum distance. The absolute value of the difference between the answer
of your program and the optimal value should be at most 10**-3. To ensure this, output your answer
with at least four digits after the decimal point (otherwise your answer, while being computed correctly,
can turn out to be wrong because of rounding issues).

Sample 1.
Input:
2
0 0
3 4
Output:
5.0
There are only two points here. The distance between them is 5.

Sample 2.
Input:
4
7 7
1 100
4 8
7 7
Output:
0.0
There are two coinciding points among the four given points. Thus, the minimum distance is zero.

Sample 3.
Input:
11
4 4
-2 -2
-3 -4
-1 3
2 3
-4 0
1 1
-1 -1
3 -1
-4 2
-2 4
Output:
1.414213
The smallest distance is √2. There are two pairs of points at this distance: ( 1, 1) and ( 2, 2); ( 2, 4) and ( 1, 3). 𝑥 𝑦
*/
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {
    private static Random random = new Random();

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }

        public String toString(){
            return "x:"+this.x+" y:"+this.y;
        }
    }

    static double bruteforce(Point[] px, int size){
        double min = Double.POSITIVE_INFINITY;
         for(int i=0 ; i < size ;i++ ){
            for(int j = i+1 ;j < size ;j++ ){
                double dist = Math.sqrt(Math.pow(px[i].x -px[j].x, 2) + Math.pow(px[i].y - px[j].y, 2 ));
                if(dist <min)
                    min = dist;
            }
         }
         return min;
    }

    static double closestsplit(Point[] px, Point[] py,double dis){
        long bar = px[px.length/2].x;
        ArrayList<Point> split = new ArrayList<>();

        for(int i = 0;i <px.length ;i++){
            if( ( bar-dis <= py[i].x ) && (py[i].x <= bar+dis) )
                split.add(py[i]);
        }

         double min = dis;
         for(int i=0 ; i < split.size() ;i++ ){
            for(int j = 1 ;j < Math.min(8 ,split.size()-i) ;j++ ){
                double dist = Math.sqrt(Math.pow(split.get(i).x - split.get(i+j).x, 2) + Math.pow(split.get(i).y - split.get(i+j).y, 2 ));
                if(dist <min)
                    min = dist;
            }
         }
         return min;

    }

    static double closest(Point[] px,Point[] py){
        int n = px.length;
        if(n<4)
            return bruteforce(px , n);
        int mid = n/2;
        Point[] lx = new Point[mid];
        Point[] ly = new Point[mid];
        Point[] rx = new Point[n-mid];
        Point[] ry = new Point[n-mid];

        for(int i = 0; i < mid ;i++){
            lx[i] = px[i];
            ly[i]=  lx[i];
        }
        for(int i = 0; i < n-mid ;i++){
            rx[i] = px[mid + i];
            ry[i] = rx[i];
        }
        
        /*
        int j=0,k=0;
        for(int i = 0 ;i < n ;i++ ){
            if( (j < mid ) && (py[i].x <px[mid].x) ){
                ly[j] = py[i];
                j++;
            }
            else {
            
                ry[k] = py[i];
                k++;
            }
        }
        */
                Arrays.sort(ly ,new Comparator<Point>(){
            public int compare(Point a,Point b ){
                if(a.x < b.x)
                    return -1;
                else if(a.x > b.x)
                    return 1;
                else 
                    return a.compareTo(b);
            }
        });

        Arrays.sort(ry , new Comparator<Point>(){
            public int compare(Point a ,Point b){
                if(a.y < b.y)
                    return -1;
                else if(a.y > b.y)
                    return 1;
                else 
                    return a.compareTo(b);
            }
        });


        double dl = closest(lx ,ly);
        double dr = closest(rx ,ry);
        double d = Math.min(dl ,dr);
        double ds = closestsplit(px ,py ,d);
        return Math.min(d,ds);
        }

    static double minimalDistance(int[] x, int y[]) {
        double ans = Double.POSITIVE_INFINITY;
        //write your code here
        Point[] px = new Point[x.length];
        Point[] py = new Point[x.length];

        Point[] points = new Point[x.length];
        for(int i = 0 ;i < x.length ;i++ ){
            points[i] = new Point(x[i] ,y[i] );
            px[i] = points[i];
            py[i] = points[i];
        }

        Arrays.sort(px ,new Comparator<Point>(){
            public int compare(Point a,Point b ){
                if(a.x < b.x)
                    return -1;
                else if(a.x > b.x)
                    return 1;
                else 
                    return a.compareTo(b);
            }
        });

        Arrays.sort(py , new Comparator<Point>(){
            public int compare(Point a ,Point b){
                if(a.y < b.y)
                    return -1;
                else if(a.y > b.y)
                    return 1;
                else 
                    return a.compareTo(b);
            }
        });

        ans = closest(px ,py);
        return ans;
        //return Math.round(ans * 1000000)/1000000d;
    }

    public static void main(String[] args) throws Exception {

        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        /*
        while(true){
        int n2=random.nextInt(10000);
        System.out.println(n2);
        int[] larray=new int[n2];
        int[] rarray=new int[n2];
        for(int i=0;i<n2;i++){
            larray[i]=random.nextInt(10000);
            rarray[i]=random.nextInt(10000);
        }
    
        Point[] points = new Point[n2];
        for(int i = 0 ;i < n2;i++ ){
            points[i] = new Point(larray[i] ,rarray[i] );
        }
        double brute=bruteforce(points,n2);
        double optimal=minimalDistance(larray, rarray);
        if(brute!=optimal){
            System.out.println("bruteans "+brute+"optimal"+optimal);
            for(int i=0;i<n2;i++){
                System.out.println(i+" "+points[i]);
            }
            break;}

        else
            System.out.println(brute+"  "+optimal+" "+n2);

    }*/
        System.out.format("%.9f",minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
