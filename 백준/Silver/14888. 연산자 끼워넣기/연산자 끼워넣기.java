import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr, oper;
    static char[] selected;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        selected = new char[n - 1];
        oper = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; ++i) {
            oper[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, arr[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(maxValue).append("\n");
        sb.append(minValue).append("\n");
        System.out.println(sb);
    }

    public static void dfs(int depth, int num) {
        if (depth == n) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            return;
        }

        for (int i = 0; i < 4; ++i) {
            if (oper[i] > 0) {
                --oper[i];
                switch (i) {
                    case 0:
                        dfs(depth + 1, num + arr[depth]);
                        break;
                    case 1:
                        dfs(depth + 1, num - arr[depth]);
                        break;
                    case 2:
                        dfs(depth + 1, num * arr[depth]);
                        break;
                    case 3:
                        dfs(depth + 1, num / arr[depth]);
                        break;
                }
                ++oper[i];
            }
        }
    }
}
