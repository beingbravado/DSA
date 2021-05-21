import java.util.Arrays;
import java.util.Scanner;

public class DP425 {
    public static int longestSubsequence(int n, int a[]) {
        // code here
        int[] z = new int[n + 1];
        int ans = 1;
        Arrays.fill(z, Integer.MAX_VALUE);
        z[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            int k = ans;
            while (a[i] <= z[k]) {
                k--;
            }
            k++;
            if (a[i] < z[k])
                z[k] = a[i];
            // System.out.print(z[i] + " ");
            ans = Math.max(ans, k);
        }
        // System.out.println();
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        System.out.println(longestSubsequence(n, a));
        scan.close();
    }
}
