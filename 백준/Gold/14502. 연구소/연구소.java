import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] lab;
    static int[][] selected;
    static boolean[][] visited;
    static boolean[][] infected;
    static int[][] d = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int maxArea = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][m];
        selected = new int[3][2];
        visited = new boolean[n][m];
        infected = new boolean[n][m];
        for (int i = 0 ; i <n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m; ++j) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        calMaxSafeArea();
        System.out.println(maxArea);
    }

    static void calMaxSafeArea() {
        comb(3, 0);
    }

    static void comb(int maxDepth, int depth) {

        if (maxDepth == depth) {
            cal();
            return;
        }

        for (int i = 0 ; i < n; ++i) {
            for (int j = 0 ; j < m; ++j) {
                if (lab[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    selected[depth][0] = i;
                    selected[depth][1] = j;
                    comb(maxDepth, depth + 1);
                    visited[i][j] = false;
                }
            }
        }
    }
    static void cal() {
        for (int i = 0 ; i < n; ++i) {
            Arrays.fill(infected[i], false);
        }

        for (int i = 0 ; i < 3; ++i) {
            int x = selected[i][0];
            int y = selected[i][1];
            lab[x][y] = 1;
        }

        for (int i = 0 ; i <n; ++i) {
            for (int j = 0 ; j < m; ++j) {
                if (lab[i][j] == 2 && !infected[i][j]) {
                    infect(i , j);
                }
            }
        }

        int answer = 0;
        for (int i = 0 ; i < n; ++i) {
            for (int j = 0 ; j < m; ++j) {
                if (lab[i][j] == 0 && !infected[i][j]) {
                    ++answer;
                }
            }
        }
        for (int i = 0 ; i < 3; ++i) {
            int x = selected[i][0];
            int y = selected[i][1];
            lab[x][y] = 0;
        }

        maxArea = Math.max(maxArea, answer);
    }

    static void infect(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        infected[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0 ; i < 4; ++i) {
                int nx = cur[0] + d[i][0];
                int ny = cur[1] + d[i][1];

                if (isIn(nx, ny) && lab[nx][ny] == 0 && !infected[nx][ny]) {
                    infected[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }

    }

    static boolean isIn(int x, int y) {
        return x>= 0 && x< n && y>= 0 && y< m;
    }
}
