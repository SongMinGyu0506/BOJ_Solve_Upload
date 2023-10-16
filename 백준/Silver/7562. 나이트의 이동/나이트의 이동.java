import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuffer sb = new StringBuffer();

    public static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};

    public static int sy,sx;
    public static int ty,tx;
    public static int mapsLength;

    public static int[][] maps;
    public static boolean[][] visited;

    public static int result = 0;


    public static void main(String[] args) throws IOException{
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            input();
            bfs();
            sb.append(result).append("\n");
        }
        output();
        
    }
    public static void input() throws IOException{
        result = 0;
        mapsLength = Integer.parseInt(br.readLine());
        maps = new int[mapsLength][mapsLength];
        visited = new boolean[mapsLength][mapsLength];

        StringTokenizer st = new StringTokenizer(br.readLine());
        sy = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ty = Integer.parseInt(st.nextToken());
        tx = Integer.parseInt(st.nextToken());
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited[sy][sx] = true;
        queue.add(new int[]{sy,sx,0});
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            int currentCounter = tmp[2];
            if((cy == ty) && (cx == tx)) {
                result = currentCounter;
                return;
            }
            for (int i = 0; i < 8; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if((ny >= 0 && ny < mapsLength) && (nx >= 0 && nx < mapsLength)) {
                    if(!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny,nx,currentCounter+1});
                    }
                }
            }
        }
    }
    public static void output() throws IOException{
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
