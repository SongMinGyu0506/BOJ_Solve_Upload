import java.util.*;
import java.io.*;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[][] maps; 
    public static boolean[][] visited;

    public static int[] dy = {0,0,1,-1};
    public static int[] dx = {1,-1,0,0};



    public static void input() throws Exception {
        maps = new int[16][16];
        visited = new boolean[16][16];
        br.readLine();
        for (int i = 0; i < 16; i++) {
            String row = br.readLine();
            for (int j = 0; j < 16; j++) {
                maps[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited[1][1] = true;
        queue.add(new int[]{1,1});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(((0 <= ny) && (ny < 16)) && ((0 <= nx) && (nx < 16))) {
                    if(maps[ny][nx] == 3) {
                        return 1;
                    }
                    if(!visited[ny][nx] && maps[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny,nx});
                    }
                }
                
            }
        }
        return 0;
    }
    public static void output(int tc) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
        bw.write(sb.toString());
    }

    public static void terminate() throws Exception {
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception{
        for (int tc = 1; tc <= 10; tc++) {
            input();
            output(tc);
        }
        terminate();
    }
}
