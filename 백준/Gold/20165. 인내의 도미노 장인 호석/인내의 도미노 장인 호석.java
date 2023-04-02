import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] isDown;
    /* N E S W */
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int n, m, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        isDown = new boolean[n][m];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        for (int i = 0; i < r * 2; ++i) {
            st = new StringTokenizer(br.readLine());
            int size = st.countTokens();
            int xPos = Integer.parseInt(st.nextToken()) - 1;
            int yPos = Integer.parseInt(st.nextToken()) - 1;

            /* attack */
            if (size == 3) {
                String dir = st.nextToken();
                answer += attack(xPos, yPos, dir);
            } else { /* defense */
                defense(xPos, yPos);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (isDown[i][j]) {
                    sb.append("F").append(" ");
                } else {
                    sb.append("S").append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int attack(int xPos, int yPos, String dir) {
        int ret = 0;
        if (isDown[xPos][yPos]) {
            return 0;
        }

        isDown[xPos][yPos] = true;
        ++ret;
        int curDominoSize = board[xPos][yPos];
        int idx = getDir(dir);

        for (int i = 0; i < curDominoSize - 1; ++i) {
            int nxPos = xPos + d[idx][0];
            int nyPos = yPos + d[idx][1];
            if (isIn(nxPos, nyPos)) {
                ret += attack(nxPos, nyPos, dir);
            }
            xPos = nxPos;
            yPos = nyPos;
        }

        return ret;
    }

    public static void defense(int xPos, int yPos) {
        isDown[xPos][yPos] = false;
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static int getDir(String dir) {
        int ret = -1;
        switch (dir) {
            case "N":
                ret = 0;
                break;
            case "E":
                ret = 1;
                break;
            case "S":
                ret = 2;
                break;
            case "W":
                ret = 3;
                break;
        }
        return ret;
    }
}
