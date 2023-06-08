import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        selected = new int[k];
        comb(k, 0);
        System.out.println(sb);
    }

    static void comb(int maxNum, int depth) {
        if (maxNum == depth) {
            for (int i = 0 ; i < selected.length; ++i) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }

        for (int i = 1; i <= n; ++i) {
            selected[depth] = i;
            comb(maxNum, depth + 1);
        }
    }
}
