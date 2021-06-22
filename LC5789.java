public class LC5789 {
    public int numberOfRounds(String startTime, String finishTime) {
        String[] s1 = startTime.split(":");
        String[] s2 = finishTime.split(":");
        int x = Integer.parseInt(s1[0]);
        int xx = Integer.parseInt(s1[1]);
        int y = Integer.parseInt(s2[0]);
        int yy = Integer.parseInt(s2[1]);
        int ans = 0;
        if (y < x || (y <= x && yy < xx)) {
            y += 24;
        }
        ans += 4 * (y - x);
        if (yy < xx) {
            yy += 60;
        }
        int min = yy / 15;
        min -= (xx + 14) / 15;
        if (yy >= 60)
            ans-=4;
        ans += min;

        return ans;
    }
}
