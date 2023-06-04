import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] cmpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        cmpArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; ++i) {
            cmpArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cmpArr);

        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < k; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < k; ++i) {
            sb.append(binary_search(n, arr[i])).append("\n");
        }
        System.out.println(sb);
    }

    static int binary_search(int n, int num) {
        int left = 0;
        int right = n;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (cmpArr[mid] > num) {
                right = mid;
            } else if (cmpArr[mid] < num) {
                left = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
