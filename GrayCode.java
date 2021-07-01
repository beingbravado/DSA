import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> gc = new ArrayList<>();
        gc.add(0);
        gc.add(1);
        for (int i = 1; i < n; i++) {
            int x = gc.size();
            int p = (int) Math.pow(2, i);
            while (x-- > 0) {
                gc.add(gc.get(x) + p);
            }
        }
        return gc;
    }
}
