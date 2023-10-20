import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int width, height;
    public static int[][] maps;
    public static boolean[][] visited;
    public static int answer = 0;

    public static int[] dy = {0,0,1,-1};
    public static int[] dx = {1,-1,0,0};

    public static void Input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        maps = new int[height][width];
        visited = new boolean[height][width];

        for(int y = 0; y < height; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < width; x++) {
                maps[y][x] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void Backtraking(int depth, int sy, int sx, int sum) {
        if(depth == 4) {
            if(answer < sum) {
                answer = sum;
            }
            return;
        }
        visited[sy][sx] = true;
        for(int i = 0; i < 4; i++) {
            int ny = sy+dy[i];
            int nx = sx+dx[i];
            if(((0 <= ny)&&(ny < height)) && ((0 <= nx)&&(nx < width)) && !visited[ny][nx]) {
                if(depth == 2) {
                    visited[ny][nx] = true;
                    for(int j = 0; j < 4; j++) {
                        int ty = sy+dy[j];
                        int tx = sx+dx[j];
                        if(((0 <= ty)&&(ty < height)) && ((0 <= tx)&&(tx < width)) && !visited[ty][tx]) {
                            Backtraking(depth+2,ty,tx,sum+maps[ny][nx]+maps[ty][tx]);
                        }
                    }
                    visited[ny][nx] = false;

                    Backtraking(depth+1,ny,nx,sum+maps[ny][nx]);

                } else {
                    Backtraking(depth+1, ny, nx, sum+maps[ny][nx]);
                }
            }
        }
        visited[sy][sx] = false;
    }
    public static void Solution() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Backtraking(1, y, x, maps[y][x]);
            }
        }
    }

    public static void Output() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void main(String[] args) throws Exception{
        Input();
        Solution();
        Output();
    }
}
