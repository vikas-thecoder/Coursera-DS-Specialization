import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int lena = a.length;
        int lenb = b.length;
        int[][] lcs = new int[lena+1][lenb+1];
        for(int i = 1 ;i <= lena ; i++){
            for(int j = 1 ;j <= lenb ;j++){
                if(a[i-1] == b[j-1])
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i][j-1],lcs[i-1][j]);
           }
        }

        return lcs[lena][lenb];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

