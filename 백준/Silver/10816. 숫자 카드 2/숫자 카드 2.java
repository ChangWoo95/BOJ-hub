import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> keys;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        keys = new ArrayList<>();
        for (int i = 0 ; i < n; ++i) {
            int key = Integer.parseInt(st.nextToken());
            keys.add(key);
        }
        Collections.sort(keys);

        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < k; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i <k; ++i) {
            int upper = upper_bound(arr[i]);
            int lower = lower_bound(arr[i]);
            sb.append(upper - lower).append(" ");
        }
        System.out.println(sb);
    }

    static int upper_bound(int num) {
        int left = 0;
        int right = keys.size() - 1;
        int mid = 0;
        int ret = keys.size();

        while(left <= right) {
            mid = (left + right) / 2;
            if (keys.get(mid) > num) {
                ret = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ret;
    }

    static int lower_bound(int num) {
        int left = 0;
        int right = keys.size() - 1;
        int mid = 0;
        int ret = keys.size();

        while(left <= right) {
            mid = (left + right) / 2;
            if (keys.get(mid) >= num) {
                ret = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ret;
    }

}
