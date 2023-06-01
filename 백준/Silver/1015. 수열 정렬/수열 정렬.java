import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] org = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; ++i) {
            org[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr = org.clone();
        Arrays.sort(arr);

        Map<Integer, List<Integer>> arrMap = new HashMap<>();
        for (int i = 0 ; i < n; ++i) {
            List<Integer> seqs = arrMap.getOrDefault(arr[i], new ArrayList<>());
            seqs.add(i);
            arrMap.put(arr[i], seqs);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n; ++i) {
            List<Integer> seqs = arrMap.get(org[i]);
            sb.append(seqs.get(0)).append(" ");
            seqs.remove(0);
            arrMap.put(org[i], seqs);
        }
        System.out.println(sb);
    }
}
