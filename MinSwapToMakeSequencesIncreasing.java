import java.util.Scanner;

public class MinSwapToMakeSequencesIncreasing {
    public static int minSwap(int[] a, int[] b) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int x = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] <= a[i - 1] || b[i] <= b[i - 1]) {
                if (x == 1)
                    x = 2;
                else
                    x = 1;
                // int temp = a[i];
                // a[i] = b[i];
                // b[i] = temp;
            }
            dp[i] = x;
        }
        int na = 0, nb = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == 1)
                na++;
            else
                nb++;
            // System.out.print(dp[i]+" ");
        }
        if(dp[1]==1) na--;
        // System.out.println(na + " " + nb);
        // System.out.println();
        return Math.min(na, nb);
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = scan.nextInt();
        System.out.println(minSwap(a, b));
        scan.close();
    }
}
