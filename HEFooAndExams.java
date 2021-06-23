import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HEFooAndExams {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            long a = Long.parseLong(s[0]);
            long b = Long.parseLong(s[1]);
            long c = Long.parseLong(s[2]);
            long d = Long.parseLong(s[3]);
            long k = Long.parseLong(s[4]);

            long l = 0, r = Math.min(k, (int) Math.cbrt(Long.MAX_VALUE / a));
            while (l <= r) {
                long mid = l + (r - l) / 2;
                if (foo(a, b, c, d, mid) > k)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            sb.append(Math.max(r, 0) + "\n");
        }
        System.out.println(sb);
    }

    public static long foo(long a, long b, long c, long d, long t) {
        return a * t * t * t + b * t * t + c * t + d;
    }
}
