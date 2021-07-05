import java.util.ArrayList;

public class CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        long MOD = (long) Math.pow(10, 9) + 7;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(0).add(4);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(4).add(2);
        graph.get(4).add(3);

        long[][] dp = new long[5][n + 1];
        for (int i = 0; i < 5; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int x : graph.get(j))
                    dp[j][i] += (dp[x][i - 1]);
                dp[j][i] = (dp[j][i] + MOD) % MOD;
            }
        }
        long sum = 0L;
        for (int i = 0; i < 5; i++) {
            sum += (dp[i][n]);
        }
        return (int) (sum % MOD);
    }
}
