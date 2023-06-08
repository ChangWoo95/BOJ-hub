import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static char[][] house;
    static boolean[][] visited;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        house = new char[n][];
        visited = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            house[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (house[i][j] == '1' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(answers);
        StringBuilder sb = new StringBuilder();
        sb.append(answers.size()).append("\n");
        for (int answer : answers) {
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int count = 1;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int curX = curNode[0];
            int curY = curNode[1];

            for (int i = 0; i < 4; ++i) {
                int nextX = curX + d[i][0];
                int nextY = curY + d[i][1];
                if (isIn(nextX, nextY) && house[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    ++count;
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }
        answers.add(count);
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}