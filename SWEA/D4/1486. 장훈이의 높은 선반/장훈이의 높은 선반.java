import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc;

    public static int answer;

    public static int N,B;
    public static boolean[] visited;
    public static int[] employees;

    public static void input() throws Exception{
        answer = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        employees = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            employees[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void sol() {
        powerSet(0, 0);
    }
    public static void powerSet(int depth, int sum) {
        if(depth == N) {
            if(sum >= B) {
                if (answer > Math.abs(sum-B)) {
                    answer = Math.abs(sum-B);
                }
            }
            return;
        }
        powerSet(depth+1, sum+employees[depth]);
        powerSet(depth+1, sum);
    }

    public static void output(int c) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("#").append(c).append(" ").append(answer).append("\n");
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
            sol();
            output(i);
        }
        terminate();
    }
}
