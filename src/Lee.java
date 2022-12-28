import java.util.LinkedList;
import java.util.Queue;

public class Lee {
    static int m = 5;
    static int n = 5;

    static boolean isOk(int[][] mat, boolean[][] seen, int row, int col) {
        return ((row >= 0) && (row < m)) && ((col >= 0) && (col < n)) && (mat[row][col] == 1) && (!seen[row][col]);
    }

    static void bfs(int[][] mat, int i, int j, int x, int y) {
        int[] row = new int[]{-1, 0, 0, 1};
        int[] col = new int[]{0, -1, 1, 0};
        boolean[][] seen = new boolean[m][n];
        Queue<Node> q = new LinkedList<Node>();
        seen[i][j] = true;
        q.add(new Node(i, j, 0));
        int minDist = -1; // как флаг
        while (!q.isEmpty()) {
            Node node = q.poll();
            i = node.x;
            j = node.y;
            int dist = node.distance;
            if (i == x && j == y) {
                minDist = dist;
                break;
            }
            for (int k = 0; k < 4; k++) {
                if (isOk(mat, seen, i + row[k], j + col[k])) {
                    seen[i + row[k]][j + col[k]] = true;
                    Node n = new Node(i + row[k], j + col[k], dist + 1);
                    q.add(n);
                }
            }
        }
        if (minDist == -1) {
            System.out.println("Данная координата недосягаема");
        } else {
            System.out.printf("Кратчайший путь имеет длину %d", minDist);
        }
    }
}
