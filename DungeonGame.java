import java.util.Scanner;

public class DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        int ans=0;
        int m= dungeon.length, n= dungeon[0].length;
        int[][] dp= new int[m+1][n+1];
        return ans;
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m= scan.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int ans = calculateMinimumHP(a);
        System.out.println(ans);
        scan.close();
    }
}
