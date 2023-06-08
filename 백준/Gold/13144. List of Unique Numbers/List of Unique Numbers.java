import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] numbers = new int[100002];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int right = 1;
        long answer = 0;

        for (int i = 1; i <= n; ++i) {
            --numbers[arr[i-1]];
            while (right <= n && numbers[arr[right]] <= 0) {
                ++numbers[arr[right++]];
            }
            answer += right - i;
        }
        System.out.println(answer);
    }
}