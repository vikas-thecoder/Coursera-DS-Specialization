/*
Problem Description
Input Format. The first line contains an integer 𝑑. The second line contains an integer 𝑚. The third line
specifies an integer 𝑛. Finally, the last line contains integers stop1,stop2
, . . . ,stop𝑛.

Output Format. Assuming that the distance between the cities is 𝑑 miles, a car can travel at most 𝑚 miles
on a full tank, and there are gas stations at distances stop1,stop2
, . . . ,stop𝑛 along the way, output the
minimum number of refills needed. Assume that the car starts with a full tank. If it is not possible to
reach the destination, output ⊔1.

Constraints. 1 ≤ 𝑑 ≤ 105. 1 ≤ 𝑚 ≤ 400. 1 ≤ 𝑛 ≤ 300. 0 < stop1 < stop2 < · · · < stop𝑛 < 𝑑.

Sample 1.
Input:
950
400
4
200 375 550 750
Output:
2
The distance between the cities is 950, the car can travel at most 400 miles on a full tank. It suffices
to make two refills: at points 375 and 750. This is the minimum number of refills as with a single refill
one would only be able to travel at most 800 miles.

Sample 2.
Input:
10
34
1 2 5 9
Output:
-1
One cannot reach the gas station at point 9 as the previous gas station is too far away.
5

Sample 3.
Input:
200
250
2
100
150
Output:
0
There is no need to refill the tank as the car starts with a full tank and can travel for 250 miles
whereas the distance to the destination point is 200 miles.
*/
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
