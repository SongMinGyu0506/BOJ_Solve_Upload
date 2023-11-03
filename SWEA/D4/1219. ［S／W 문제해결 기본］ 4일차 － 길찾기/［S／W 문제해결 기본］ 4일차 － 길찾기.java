import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static ArrayList<Integer>[] maps;
    public static boolean[] visited;
    public static int N;
    public static int answer;

    public static void input() throws Exception {
        answer = 0;
        maps = new ArrayList[100];
        for (int i = 0; i < 100; i++) {
            maps[i] = new ArrayList<>();
        }
        visited = new boolean[100];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            maps[a].add(b);
        }
    }

    public static void sol() {
        answer = bfs();
    }
    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int next : maps[current]) {
                if(next == 99) {
                    return 1;
                }
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
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
            input();
            sol();
            output(i);
        }
        terminate();
    }
}
