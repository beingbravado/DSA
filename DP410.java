import java.util.*;

public class DP410{
    public static long count(int s[], int m, int n) {
        // code here.
        long[] dp= new long[n+1];
        Arrays.fill(dp, 0);
        dp[0]=1;
        for(int i=0;i<m;i++){
            for(int j=s[i];j<=n;j++){
                dp[j]+=dp[j-s[i]];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();
        int m = scan.nextInt();
        int[] s= new int[m];
        for (int i = 0; i < s.length; i++) {
            s[i]= scan.nextInt();
        }
        System.out.println(count(s, m, n));
        scan.close();
    }
}