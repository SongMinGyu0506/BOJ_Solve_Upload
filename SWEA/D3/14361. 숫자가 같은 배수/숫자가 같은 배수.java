import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int tc;

    public static boolean[] visited;

    public static String answer, N;

    public static void input() throws Exception {
        answer = "";
        N = br.readLine();
        visited = new boolean[N.length()];
    }

    public static void sol() throws Exception {
        backtraking(0,"");
        if(answer.equals("")) answer = "impossible";
    }

    public static void backtraking(int depth, String makeNumber) {
        if(depth == N.length()) {
            int checkMakeNumber = Integer.parseInt(makeNumber);
            int integerN = Integer.parseInt(N);
            if(checkMakeNumber % integerN == 0 && checkMakeNumber / integerN > 1 ) {
                answer = "possible";
                return;
            }
        }
        for(int i = 0; i < N.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtraking(depth+1,makeNumber+N.charAt(i));
                visited[i] = false;
            }
        }
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
        tc = Integer.parseInt(br.readLine());
        for(int i = 1; i <= tc; i++) {
            input();
            sol();
            output(i);
        }
        terminate();
    }
}
