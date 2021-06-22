public class LC69 {
    public int mySqrt(int x) {
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (square(mid) >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return square(l) > x ? l - 1 : l;
    }

    public static long square(long x) {
        return x * x;
    }
}
