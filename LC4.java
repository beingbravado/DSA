public class LC4 {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length == 0)
            return b.length % 2 == 0 ? (double) (b[b.length / 2 - 1] + b[b.length / 2]) / 2 : b[b.length / 2];
        if (b.length == 0)
            return a.length % 2 == 0 ? (double) (a[a.length / 2 - 1] + a[a.length / 2]) / 2 : a[a.length / 2];

        if (a.length > b.length)
            return findMedianSortedArrays(b, a);

        int median = (a.length + b.length) / 2;
        int low = 0, high = Math.min(a.length, median);
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = median - cut1;
            double l1 = cut1 <= 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            double l2 = cut2 <= 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            double r1 = cut1 >= a.length ? Integer.MAX_VALUE : a[cut1];
            double r2 = cut2 >= b.length ? Integer.MAX_VALUE : b[cut2];
            System.out.println(l1 + " " + r1);
            System.out.println(l2 + " " + r2);

            if (l1 > r2)
                high = cut1 - 1;
            else if (l2 > r1)
                low = cut1 + 1;
            else
                return (a.length + b.length) % 2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2 : Math.min(r1, r2);
        }
        return 0;
    }
}
