import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] arr = new List[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken()) - 1;
            arr[color].add(num);
        }
        int answer = 0;
        for (int i = 0; i < n; ++i) {
            Collections.sort(arr[i]);
            for (int j = 0; j < arr[i].size(); ++j) {
                int leftValue = Integer.MAX_VALUE;
                int rightValue = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    leftValue = arr[i].get(j) - arr[i].get(j - 1);
                }
                if (j + 1 < arr[i].size()) {
                    rightValue = arr[i].get(j + 1) - arr[i].get(j);
                }
                answer += Math.min(leftValue, rightValue);

            }
        }

        System.out.println(answer);
    }
}
