import java.util.Arrays;

public class DP435 {
    public static int maxSumPairWithDifferenceLessThanK(int a[], int n, int k) {
        // Your code goes here
        Arrays.sort(a);
        int ans = 0, x = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (Math.abs(x - a[i]) < k) {
                ans += x + a[i];
                i--;
                if (i >= 0)
                    x = a[i];
            } else {
                x = a[i];
            }
        }
        return ans;
    }
}
