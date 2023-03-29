import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    * 1. 부분집합을 구한다 (power set 구상을 할 수 있는가?)
    * 2. 공집합인 경우가 반드시 나오게 되는데 합이 0인 경우와 공집합인 경우를 나눠 생각해주는 기술이 필요
    *  */
    public static int answer = 0;
    public static int n;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        result = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, arr);
        if (result == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }

    }
    public static void dfs(int depth, int sumResult, int[] arr) {
        if (depth == n) {
            if (sumResult == result) {
                ++answer;
            }
            return;
        }

        dfs(depth + 1, sumResult + arr[depth], arr);
        dfs(depth + 1, sumResult, arr);
    }

}
