import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static boolean[] visited;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception{
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M+1];
        visited = new boolean[N+1];
        Solution(N, M, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Solution(int N, int M, int depth) {
        if (depth == M) {
            for(int i = 0; i < arr.length-1; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (depth-1 == -1) {
                    visited[i] = true;
                    arr[depth] = i;
                    Solution(N, M, depth+1);
                    visited[i] = false;
                    continue;
                }
                if (arr[depth-1] < i) {
                    visited[i] = true;
                    arr[depth] = i;
                    Solution(N, M, depth+1);
                    visited[i] = false;
                }
                
            }
        }
    }
}
