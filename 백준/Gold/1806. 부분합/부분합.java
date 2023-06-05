import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = Integer.MAX_VALUE;
        int result = 0;
        int right = 0;

        for (int i = 1; i <= n; ++i) {
            result -= arr[i - 1];

            while (right + 1 <= n && result < m) {
                result += arr[++right];
            }

            if (result >= m) {
                len = Math.min(len, right - i + 1);
            }
        }
        System.out.println((len == Integer.MAX_VALUE) ? 0 : len);
    }
}