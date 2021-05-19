import java.util.*;

public class DP412 {
    public static int MOD = 1000000007;

    public static int nCr(int n, int r) {
        // code here
        long[] fact = new long[n + 1];
        Arrays.fill(fact, 0);
        fact[0] = 1;
        if (r > n)
            return 0;
        int num = (int) (((factorial(fact, n) / ((factorial(fact, n - r) * factorial(fact, r) % MOD))) + MOD) % MOD);
        for (int i = 0; i <= n; i++)
            System.out.print(fact[i] + " ");
        System.out.println();
        return num;
    }

    public static long factorial(long[] fact, int n) {
        if (fact[n] > 0)
            return fact[n];
        return fact[n] = factorial(fact, n - 1) * n % MOD;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int r = scan.nextInt();
        System.out.println(nCr(n, r));
        scan.close();
    }
}
