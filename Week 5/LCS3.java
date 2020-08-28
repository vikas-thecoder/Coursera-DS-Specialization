import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
        int[][][] lcs = new int[a.length + 1][b.length + 1][c.length + 1];
        for(int i = 0; i <= a.length ;i++){
            for(int j = 0; j<= b.length; j++){
                for(int k = 0; k <= c.length ; k++){
                    if(i==0 || j==0 || k==0)
                        lcs[i][j][k] = 0;
                    else if((a[i-1] == b[j-1]) && (b[j-1] == c[k-1]))
                        lcs[i][j][k] = lcs[i-1][j-1][k-1] + 1;
                    else
                        lcs[i][j][k] = Math.max(lcs[i][j][k-1],Math.max(lcs[i][j-1][k],lcs[i-1][j][k]));
                }
            }
        }
        return lcs[a.length][b.length][c.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

