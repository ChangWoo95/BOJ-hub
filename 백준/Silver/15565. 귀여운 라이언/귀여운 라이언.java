import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    * 10 3
    * 1 2 2 2 1 2 1 2 2 1
    * 6
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int right = 1;
        int answer = -1;

        for (int i = 1; i <=n; ++i) {
            if (arr[i-1] == 1) {
                count -= 1;
            }

            while (right <= n && count < k) {
                if (arr[right] == 1) {
                    ++count;
                }
                ++right;
            }

            if (count >= k) {
                if (answer == -1) answer = right - i;
                else answer = Math.min(answer, right - i);
            }
        }
        System.out.println(answer);
    }
}
