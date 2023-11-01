import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc;
    public static int[][] maps;
    public static boolean[][] visited;
    public static HashSet<String> store;

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static int answer;

    public static void input() throws Exception {
        answer = 0;
        store = new HashSet<>();
        visited = new boolean[4][4];
        maps = new int[4][4];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void sol() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                backtraking(0, String.valueOf(maps[i][j]), i, j);
            }
        }
    }
    public static void backtraking(int depth, String code, int y, int x) {
        if (depth == 6) {
            store.add(code);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(((0 <= nx)&&(nx < 4))&&((0 <= ny)&&(ny < 4))) {
                backtraking(depth+1, code+maps[ny][nx], ny, nx);
            }
        }
    }
    public static void output(int tc) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("#").append(tc).append(" ").append(store.size()).append("\n");
        bw.write(sb.toString());
    }

    public static void terminate() throws Exception {
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception{
        tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            input();
            sol();
            output(i);
        }
        terminate();
    }
}
