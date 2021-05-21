import java.util.Arrays;
import java.util.Scanner;

public class DP417 {
    public static int equalPartition(int n, int a[]) {
        // code here
        int sum=0;
        for(int i=0;i<n;i++) sum+= a[i];
        if(sum%2==1){
            return 0;
        } else {
            sum/=2;
            boolean[][] dp= new boolean[n+1][sum+1]; 
            // Arrays.fill(dp, 0);
            for(int i=0;i<=n;i++) dp[i][0]= true;
            for(int i=1;i<=n;i++){
                if(a[i-1]>sum) return 0;
                for(int j=a[i-1];j<=sum;j++){
                    dp[i][j]= dp[i-1][j] | dp[i-1][j-a[i-1]];
                }
            }
            if(dp[n][sum]) return 1;
        }
        return 0;
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++) a[i]= scan.nextInt();
        System.out.println(equalPartition(n, a));
        scan.close();
    }
}
