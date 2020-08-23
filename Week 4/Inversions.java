import java.util.*;

public class Inversions {
    private static long merge(int[] a, int left, int mid,int right){
        int lsize = mid - left, rsize = right - mid ;
        long inv = 0;
        int[] larray = new int[lsize];
        int[] rarray = new int[rsize];
        
        for( int k = 0;k < lsize;k++){
            larray[k] = a[left + k];
        }

        for(int k = 0;k < rsize;k++ ){
            rarray[k] = a[mid + k];
        }

        int k = left;
        int i = 0 ,j = 0;
        while((i < lsize) && (j < rsize)){
            if(larray[i] <= rarray[j]){
                a[k++] = larray[i++];
            }
            else{
               // System.out.println(larray[i])
                inv+=lsize-i;
                a[k++] = rarray[j++];
            }
        }
        while(i < lsize)
            a[k++] = larray[i++];

        while(j < rsize)
            a[k++] = rarray[j++];
        return inv;
    }

    private static long getNumberOfInversions(int[] a, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = left +((right - left) / 2);
        numberOfInversions += getNumberOfInversions(a, left, ave);
        numberOfInversions += getNumberOfInversions(a, ave, right);
        //write your code here
        numberOfInversions += merge(a ,left ,ave ,right );
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long inv=getNumberOfInversions(a, 0, a.length);
        System.out.println(inv);
    }
}

