import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] maps;
    public static boolean[] visited;
    public static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        maps = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            maps[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            maps[a].add(b);
            maps[b].add(a);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            ans = 0;
            dfs(i,0);
            if(ans >= 1) {
                sb.append("1").append("\n");
                break;
            }
        }
        if (ans <= 0) {
            sb.append("0").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int start, int depth) {
        if (depth == 4) {
            ans = 1;
            return;
        }
        visited[start] = true;
        for(int next : maps[start]) {
            if(!visited[next]) {
                dfs(next,depth+1);
            }
        }
        visited[start] = false;
    }
}
