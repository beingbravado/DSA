import java.util.ArrayList;
import java.util.Scanner;

public class DP447 {
    public static int wordBreak(String a, ArrayList<String> b) {
        // code here
        boolean[] dp = new boolean[a.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                String search = a.substring(j, i + 1);
                // System.out.print(search + " ");
                if (b.contains(search)) {
                    if (j == 0)
                        dp[i] = true;
                    else
                        dp[i] = dp[j - 1] | dp[i];
                }
            }
            // System.out.println();
        }
        // for (int i = 0; i < dp.length; i++)
        //     System.out.print(dp[i] + " ");
        // System.out.println();
        return dp[dp.length - 1] ? 1 : 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String a = scan.next();
        ArrayList<String> b = new ArrayList<>();
        for (int i = 0; i < n; i++)
            b.add(scan.next());
        System.out.println(wordBreak(a, b));
        scan.close();
    }
}
