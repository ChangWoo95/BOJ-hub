import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0 ; i < n; ++i) {
            String extension = br.readLine().split("\\.")[1];
            int count = wordMap.getOrDefault(extension, 0);
            wordMap.put(extension, count + 1);
        }
        List<String> keys = new ArrayList<>(wordMap.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append(" ").append(wordMap.get(key)).append("\n");
        }

        System.out.println(sb);
    }
}
