import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<BigInteger, Integer> numberMap = new HashMap<>();
        for (int i = 0 ; i < n; ++i) {
            BigInteger number  = new BigInteger(br.readLine());
            int count = numberMap.getOrDefault(number, 0);
            numberMap.put(number, count + 1);
        }
        BigInteger answer = BigInteger.ZERO;
        int num = 0;
        for (Map.Entry<BigInteger, Integer> en : numberMap.entrySet()) {
            if (num <= en.getValue()) {
                if (num == en.getValue()) {
                    if (en.getKey().compareTo(answer) < 0) {
                        answer = en.getKey();
                    }
                } else {
                    answer = en.getKey();
                    num = en.getValue();
                }
            }
        }
        System.out.println(answer);
    }
}
