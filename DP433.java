import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DP433 {
    public static class pair {
        int x, y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class CompareByFirst implements Comparator<pair> {
        public int compare(pair a, pair b) {
            return a.x - b.x;
        }
    }

    public static class Compare {
        void compare(pair a[], int n) {
            // Comparator to sort the pair according to second element
            Arrays.sort(a, new Comparator<pair>() {
                @Override
                public int compare(pair p1, pair p2) {
                    return p1.x - p2.x;
                }
            });
        }
    }

    public static int maxChainLength(pair a[], int n) {
        // your code here
        int[] dp = new int[n];
        Compare obj = new Compare();
        obj.compare(a, n);
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[i].x > a[j].y) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        pair[] a = new pair[n];
        for (int i = 0; i < n; i++)
            a[i] = new pair(scan.nextInt(), scan.nextInt());
        System.out.println(maxChainLength(a, n));
        scan.close();
    }
}
