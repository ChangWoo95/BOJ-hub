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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binary_search(arr, m));
    }

    static long binary_search(int[] arr ,int m) {
        long left = 0;
        long right = 2000000000L;
        long mid = 0;
        long answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            long result = 0;
            for (int i = 0 ; i < arr.length; ++i) {
                if (arr[i] > mid) {
                    result += arr[i] - mid;
                }
            }
            if (result >= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
