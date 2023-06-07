import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    * 2
    * abbcaccba
    * 4
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] alpha = new int[26];

        int curCount = 0;
        int answer = -1;


        for (int left = 0, right = 0; right < s.length(); ++right) {
            ++alpha[s.charAt(right) - 'a'];
            if (alpha[s.charAt(right) - 'a'] == 1) {
                ++curCount;
            }

            while (curCount > n) {
                --alpha[s.charAt(left) - 'a'];
                if (alpha[s.charAt(left++) - 'a'] == 0) {
                    --curCount;
                }
            }
            answer = Math.max(answer, right - left + 1);
        }
        System.out.println(answer);
    }
}
