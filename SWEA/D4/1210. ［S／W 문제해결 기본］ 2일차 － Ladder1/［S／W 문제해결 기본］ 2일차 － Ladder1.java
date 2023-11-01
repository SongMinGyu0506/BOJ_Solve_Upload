import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc;
    public static int[][] maps;
    public static boolean[][] visited;
    public static ArrayList<int[]> startPos;
    public static int answer;

    public static int[] dx = {1,-1};
    public static boolean checker;

    public static void input() throws Exception {
        answer = 0;
        maps = new int[100][100];
        startPos = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for (int j = 0; j < maps.length; j++) {
                String token = st.nextToken();
                if(i ==0 && Integer.parseInt(token) == 1) {
                    startPos.add(new int[]{i,j});
                }
                maps[i][j] = Integer.parseInt(token);
            }
        }
    }

    public static void algo() {
        for (int[] i : startPos) {
            visited = new boolean[100][100];
            checker = false;
            visited[i[0]][i[1]] = true;
            backtraking(i[0], i[1], i[1]);
            visited[i[0]][i[1]] = true;
        }
    }

    public static void backtraking(int y, int x, int startAnswer) {
        if(y == 99) {
            checker = true;
        }
        if(maps[y][x] == 2) {
            answer = startAnswer;
            return;
        }
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            if((0 <= nx ) && (nx < 100) && maps[y][nx] == 1 && (visited[y][nx] == false)) {
                visited[y][nx] = true;
                backtraking(y, nx, startAnswer);
                visited[y][nx] = false;

                if(checker) return;
            }
        }
        if((0 <= y+1)&&(y+1 < 100) && (maps[y+1][x] == 1 || maps[y+1][x] == 2)) {
            visited[y+1][x] = true;
            backtraking(y+1, x, startAnswer);
            visited[y+1][x] = false;
        }
    }

    public static void output(int tc) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("#").append(tc).append(" ").append(answer).append("\n");
        bw.write(sb.toString());
    }

    public static void terminate() throws Exception {
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception{
        for (int i = 1; i <= 10; i++) {
            tc = Integer.parseInt(br.readLine());
            input();
            algo();
            output(i);
        }
        terminate();
    }
}
