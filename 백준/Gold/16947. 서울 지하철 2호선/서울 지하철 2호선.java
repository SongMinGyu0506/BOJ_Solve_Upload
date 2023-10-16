import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer>[] maps;
    public static boolean[] visited;
    public static int[] distance;
    public static boolean[] isCycle;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        maps = new ArrayList[N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];
        for (int i = 0; i <= N; i++) {
            maps[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            maps[a].add(b);
            maps[b].add(a);
        }
        checkCycle(N);
        getDistance(N);
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N-1; i++) {
            sb.append(distance[i]).append(" ");
        }
        sb.append(distance[N]).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getDistance(int N) {
        distance = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            if(isCycle[i] && maps[i].size() > 2) {
                searchDistance(i);
            }
        }
    }

    public static void searchDistance(int current) {
        for(int next : maps[current]) {
            if(isCycle[next] || distance[next] > 0) {
                continue;
            }
            distance[next] = distance[current]+1;
            searchDistance(next);
        }
    }

    public static void checkCycle(int N) {
        isCycle = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if(!isCycle[i]) {
                visited = new boolean[N+1];
                dfs(i,i,0);
            }
        }
    }
    public static boolean dfs(int start, int current, int depth) {
        for(int next: maps[current]) {
            if(next == start) {
                if (depth > 1) {
                    return isCycle[current] = true;
                } else {
                    continue;
                }
            }
            if(isCycle[next] || isCycle[current] || visited[next]) {
                continue;
            }
            visited[next] = true;
            isCycle[current] = dfs(start, next, depth+1);
        }
        return isCycle[current];
    }
}
