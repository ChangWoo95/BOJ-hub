import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class StudentInfo {
        String name;
        int kor;
        int math;
        int eng;

        public StudentInfo(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.math = math;
            this.eng = eng;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StudentInfo[] studentInfos = new StudentInfo[n];

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            studentInfos[i] = new StudentInfo(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(studentInfos, (x1, x2) -> {
            if (x1.kor != x2.kor) {
                return Integer.compare(x2.kor, x1.kor);
            } else {
                if (x1.eng == x2.eng) {
                    if (x1.math == x2.math) {
                        return x1.name.compareTo(x2.name);
                    } else {
                        return Integer.compare(x2.math, x1.math);
                    }
                } else {
                    return Integer.compare(x1.eng, x2.eng);
                }
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (StudentInfo studentInfo : studentInfos) {
            sb.append(studentInfo.name).append("\n");
        }
        System.out.println(sb);
    }
}
