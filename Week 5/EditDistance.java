import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
    int lens = s.length();
    int lent = t.length();
    int[][] mindis = new int[lens + 1][lent + 1];
    for(int i = 0; i <= lens ; i++){
      mindis[i][0] = i; 
    }
    for(int j = 0 ;j <= lent ;j++){
      mindis[0][j] = j; 
    }
    for( int i = 1; i <= lens; i++){
      for(int j = 1; j <= lent; j++){
        int ins = mindis[i][j-1] + 1;
        int del = mindis[i-1][j] + 1;
        int equal = mindis[i-1][j-1];
        int mismatch = mindis[i-1][j-1] + 1;  
        if(s.charAt(i-1) != t.charAt(j-1))
          mindis[i][j] = Math.min(ins,Math.min(del,mismatch));
        else
          mindis[i][j] = Math.min(ins,Math.min(del,equal));
      }

    }
    return mindis[lens][lent];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
