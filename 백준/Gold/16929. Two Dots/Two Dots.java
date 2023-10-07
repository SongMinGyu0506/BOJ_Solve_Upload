import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static char[][] maps;
    public static Boolean[][] visited;
    public static int N,M;
    public static String ans = "No";

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new char[N][M];
        visited = new Boolean[N][M];



        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = str.charAt(j);
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i,j,1,i,j);
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(ans).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int y, int x, int depth, int startY, int startX) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if((ny >= 0 && ny < N) && (nx >= 0 && nx < M)) {
                if(depth >= 4 && maps[ny][nx] == maps[y][x] && ny == startY && nx == startX) {
                    ans = "Yes";
                    return;
                }
                if(maps[ny][nx] == maps[y][x] && !visited[ny][nx]) {
                    dfs(ny,nx,depth+1,startY,startX);
                }
            }
        }
        visited[y][x] = false;
    }
}
