public class LC204 {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] prime = new boolean[n + 1];
        for (int x = 2; x < n; x++)
            if (!prime[x]) {
                count++;
                isPrime(prime, x);
                if (x > 2)
                    x++;
            }
        return count;
    }

    public static void isPrime(boolean[] prime, int n) {
        if (n * n >= prime.length)
            return;
        for (int x = n + n; x < prime.length; x += n) {
            prime[x] = true;
        }
    }
}
