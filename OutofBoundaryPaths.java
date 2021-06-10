import java.util.Scanner;

public class OutofBoundaryPaths {
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp= new int[m+1][n+1];
        return dp[m][n];
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int m= scan.nextInt();
        int n = scan.nextInt();
        int maxMove = scan.nextInt();
        int startRow = scan.nextInt();
        int startColumn = scan.nextInt();
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
        scan.close();
    }
}