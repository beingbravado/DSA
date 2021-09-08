import java.util.Arrays;

public class BM473 {
    public int[] singleNumber(int[] nums) {
        // Code here
        int ans[] = new int[2];
        int sum = 0;
        for (int x : nums)
            sum ^= x;
        sum = sum & (-sum);
        for (int x : nums) {
            if ((x & sum) == 0)
                ans[0] ^= x;
            else
                ans[1] ^= x;
        }
        Arrays.sort(ans);
        return ans;
    }
}
