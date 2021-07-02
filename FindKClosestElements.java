import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int l = -1, r = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < x)
                l = i;
            else {
                r = i;
                break;
            }
        }
        System.out.println(l + " " + r);
        int kk = k;
        while (k-- > 0) {
            if (l >= 0 && r < arr.length) {
                if (Math.abs(x - arr[r]) < Math.abs(x - arr[l]))
                    r++;
                else
                    l--;
            } else if (l >= 0) {
                l--;
            } else {
                r++;
            }
        }

        int t = l + 1;
        while (kk-- > 0) {
            ans.add(arr[t]);
            t++;
        }
        return ans;
    }
}
