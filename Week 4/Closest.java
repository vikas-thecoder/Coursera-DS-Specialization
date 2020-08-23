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
