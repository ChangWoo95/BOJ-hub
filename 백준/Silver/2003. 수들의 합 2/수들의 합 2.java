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
        for (int i = 1 ; i <= n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        int sum = 0;
        int answer = 0;

        for (int i = 1; i <= n; ++i) {
            sum -= arr[i - 1];

            while (right + 1 <= n && sum < m) {
                sum += arr[++right];
            }
            if (sum == m) ++answer;
        }
        System.out.println(answer);
    }
}