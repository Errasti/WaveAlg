public class Start {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1},
                        {1, 1, 0, 0, 0}
                };
        Lee.bfs(matrix, 0, 0, 3, 4);
    }
}
