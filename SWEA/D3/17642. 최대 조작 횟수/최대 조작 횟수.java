import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc;
    public static long A,B,answer;

    public static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        answer = 0;
    }

    public static void sol() {
        if(A == B) {
          answer = 0;
          return;
        }
                if(A > B) {
            answer = -1;
            return;
        }
        if(Math.abs(A-B) == 1) {
            answer = -1;
            return;
        }
        long tmp = Math.abs(A-B);
        if(tmp % 2 == 0) {
            answer = tmp/2;
        } else {
            answer = (tmp-3)/2 + 1;
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
