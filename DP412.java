import java.util.*;

public class DP412 {
    public static int MOD = 1000000007;

    public static int nCr(int n, int r) {
        // code here
        long[][] fact = new long[n + 1][r + 1];
        // Arrays.fill(fact, 0);
        long num = C(n, r, fact) % MOD;
        return (int)num;
    }

    public static long C(int n, int r, long[][] fact) {
        if (r > n)
            return 0;
        if (r == 0 || r == n)
            return fact[n][r] = 1;

        if (fact[n][r] >0)
            return fact[n][r] % MOD;
        return fact[n][r] = C(n - 1, r - 1, fact) % MOD + C(n - 1, r, fact) % MOD;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int r = scan.nextInt();
        System.out.println(nCr(n, r));
        scan.close();
    }
}
