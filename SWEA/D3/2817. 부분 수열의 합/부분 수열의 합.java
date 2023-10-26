import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc;
    public static int N,K;
    public static int[] arr;
    public static boolean[] visited;
    public static int answer = 0;

    public static void input() throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = 0;
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void algorithm(int depth) {
        if(depth == N) {
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                if(visited[i]) {
                    tmp += arr[i];
                }
            }
            if (K == tmp) answer++;
            return;
        }

        visited[depth] = true;
        algorithm(depth+1);
        visited[depth] = false;
        algorithm(depth+1);
    }

    public static void output(int tc) throws Exception{
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
        tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            input();
            algorithm(0);
            output(i);
        }
        terminate();
    }
}