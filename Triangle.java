import java.util.ArrayList;
import java.util.Scanner;

public class Triangle {
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(triangle.size() - 1));
        for (int i = 1; i < triangle.size(); i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j < triangle.size() - i; j++) {
                dp.get(i).add(triangle.get(triangle.size() - i - 1).get(j)
                        + Math.min(dp.get(i - 1).get(j), dp.get(i - 1).get(j + 1)));
            }
        }
        // System.out.println(dp);
        return dp.get(triangle.size() - 1).get(0);
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            triangle.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                triangle.get(i).add(scan.nextInt());
            }
        }
        // System.out.println(triangle);
        System.out.println(minimumTotal(triangle));
        scan.close();
    }
}
