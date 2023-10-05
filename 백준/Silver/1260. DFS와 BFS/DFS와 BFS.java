

import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] maps;
    public static Boolean[] visited;
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        maps = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            maps[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            maps[a].add(b);
            maps[a].sort(Comparator.naturalOrder());
            maps[b].add(a);
            maps[b].sort(Comparator.naturalOrder());
        }

        visited = new Boolean[N+1];
        Arrays.fill(visited, Boolean.FALSE);
        dfs(V);
        sb.append("\n");
        visited = new Boolean[N+1];
        Arrays.fill(visited, Boolean.FALSE);
        bfs(V);
        sb.append("\n");
        writer.write(sb.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");
            for(int next : maps[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start);
        for(int next : maps[start]) {
            if(!visited[next]) {
                sb.append(" ");
                dfs(next);
            }
        }
    }
}
