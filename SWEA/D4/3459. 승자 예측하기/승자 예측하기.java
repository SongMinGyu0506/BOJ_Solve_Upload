import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc;
    public static Long N;
    public static String answer;

    public static void input() throws Exception {
        N = Long.parseLong(br.readLine());
        answer = "";
    }
    public static void sol() {
        if (N == 1) {
            answer = "Bob";
            return;
        }
       if (N == 2 || N==3 ) {
           answer = "Alice";
           return;
       }
        while(N > 3) {
            N = N/2+1;
            N = N/2-1;

            if(N >= 2 || N==0) {
                answer = "Alice";
            } else {
                answer = "Bob";
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
        for (int i = 1; i <= tc; i++) {
            input();
            sol();
            output(i);
        }
        terminate();
    }
}
