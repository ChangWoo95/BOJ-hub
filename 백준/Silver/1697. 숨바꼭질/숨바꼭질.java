import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static int[] d = {2, 1, -1};
    static boolean[] visited = new boolean[100001];
    static int[] dist = new int[100001];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) {
                answer = dist[cur];
                break;

            }
            for (int i = 0; i < 3; ++i) {
                int nxt = 0;
                if (i == 0) {
                    nxt = cur * d[i];
                } else {
                    nxt = cur + d[i];
                }
                if (nxt >= 0 && nxt <= 100000 && !visited[nxt]) {
                    dist[nxt] = dist[cur] + 1;
                    visited[nxt] = true;
                    q.offer(nxt);
                }
            }
        }
    }
}
