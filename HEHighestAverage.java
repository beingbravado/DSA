import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class HEHighestAverage {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine().trim());
        String[] array = br.readLine().trim().split(" ");
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++)
            a[i] = Long.parseLong(array[i]);
        Arrays.sort(a);
        ArrayList<Long> dp = new ArrayList<>();
        dp.add(a[0]);
        for (int i = 1; i < n; i++)
            dp.add(dp.get(i - 1) + a[i]);
        // System.out.println(dp);
        long q = Long.parseLong(br.readLine().trim());
        while (q-- > 0) {
            long k = Long.parseLong(br.readLine().trim());
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                // System.out.println("mid: " + mid);
                double avg = dp.get(mid) / (double) (mid + 1);
                // System.out.println("avg: " + avg);
                if (avg < k)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            sb.append(l + "\n");
        }
        System.out.println(sb);
    }
}
