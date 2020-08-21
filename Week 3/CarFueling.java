import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int fuelcount=0;
        int currStop=0;
        int[] stations=new int[stops.length+2];
        stations[stations.length-1]=dist;
        for(int i=1;i<stations.length-1;i++){
            stations[i]=stops[i-1];
        }
      
        while(currStop<=stations.length-2){
            int prevStop=currStop;
            while((currStop<=stations.length-2) && ((stations[currStop+1]-stations[prevStop])<=tank))
                currStop+=1;
            if (currStop==prevStop)
                return -1;
            if (currStop<=stations.length-2)
                fuelcount++;
        }
        return fuelcount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
