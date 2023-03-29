import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static boolean[] visited;
    public static int[] arr;
    public static int[] selected;
    public static Set<String> answerSet = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        selected = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        StringBuilder sb = new StringBuilder();
        for (String answer : answerSet) {
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0 ; i < m; ++i) {
                sb.append(selected[i]).append(" ");
            }
            if (!answerSet.contains(sb.toString())) {
                answerSet.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
