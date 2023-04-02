import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;

    /*
    * 1. 자릿수에 따른 재귀호출을 생각할 수 있는가.
    * 2. 숫자를 잘라낼 때, 2중  for문의 범위를 생각할 수 있는가.
    *  */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int count = getOddCount(n);
        dfs(n, count);
        System.out.println(minValue + " " + maxValue);
    }
    
    public static void dfs(int result, int oddCount) {
        /* 한자리일 경우 */
        if (result <= 9) {
            minValue = Math.min(minValue, oddCount);
            maxValue = Math.max(maxValue, oddCount);

        } else if (result < 100) {
            int num = (result / 10) + (result % 10);
            dfs(num, oddCount + getOddCount(num));
            return;
        } else {
            String s = Integer.toString(result);
            int len = s.length();
            for (int i = 0; i <= len - 3; ++i) {
                for (int j = i+1; j <= len-2; ++ j) {
                    String num1 = s.substring(0, i+1);
                    String num2 = s.substring(i+1, j+1);
                    String num3 = s.substring(j+1, len);
                    int num = Integer.parseInt(num1)  + Integer.parseInt(num2) + Integer.parseInt(num3);
                    dfs(num, oddCount + getOddCount(num));
                }
            }
        }
    }

    public static int getOddCount(int result) {
        int ret = 0;
        while (result != 0) {
            if ( (result % 10) % 2 != 0) {
                ++ret;
            }
            result /= 10;
        }
        return ret;
    }
}
