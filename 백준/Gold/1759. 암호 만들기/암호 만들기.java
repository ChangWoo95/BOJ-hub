import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int r;
    public static int n;
    public static char[] selected;
    public static char[] word;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        /* 
        * 1. 문제의 validation으로 인해 선 정렬 진행 -> 그렇다면 순열이 필요하지 않게 됨을 알고 있는가
        *  */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        word = new char[n];
        selected = new char[r];
        visited = new boolean[word.length];
        for (int i = 0 ; i < n; ++i) {
            word[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(word);
        perm(0, 0);

        System.out.println(sb);
    }

    public static void perm(int depth, int start) {
        if (depth == r) {
            String result = String.valueOf(selected);
            if (!isCompleteCondition(result)) return;
            sb.append(result).append("\n");
            return;
        }

        for (int i = start ; i < n; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = word[i];
                perm(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isCompleteCondition(String org) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0 ; i < org.length(); ++i) {
            char ch = org.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                ++vowelCount;
            } else {
                ++consonantCount;
            }
        }
        return vowelCount >= 1 && consonantCount >= 2;
    }
}
