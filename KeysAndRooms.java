import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        boolean ans = true;
        visitRooms(rooms, visited, 0);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    public static void visitRooms(List<List<Integer>> rooms, boolean[] visited, int room) {
        if (visited[room])
            return;
        visited[room] = true;
        for (int x : rooms.get(room)) {
            visitRooms(rooms, visited, x);
        }
    }
}
