import java.util.Scanner;

public class DP421 {
    static int mod = 1000000007;

    public static long countWays(int n, int k) {
        // code here.
        long x = 0, y = k;
        long ans = k;
        for (int i = 2; i <= n; i++) {
            x = y;
            y = ans * (k - 1) % mod;
            ans = (x + y) % mod;
            // System.out.println(x + " " + y + " " + ans);
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        System.out.println(countWays(n, k));
        scan.close();
    }
}
