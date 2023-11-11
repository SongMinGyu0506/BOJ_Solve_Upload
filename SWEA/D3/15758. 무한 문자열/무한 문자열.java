import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc;
    public static String S,T,answer;

    public static void input() throws Exception {
        answer = "";
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        T = st.nextToken();
    }
    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    private static int lcm(int a, int b) {
        return a * b / gcd(a,b);
    }
    public static void sol() {
        if(S.length() == T.length()) {
            if(S.equals(T)) {
                answer = "yes";
            } else {
                answer = "no";
            }
        } else {
            int lcm = lcm(S.length(), T.length());
            String tTmp = "";
            String sTmp = "";
            while(tTmp.length() != lcm) {
                tTmp += T;
            }
            while(sTmp.length() != lcm) {
                sTmp += S;
            }
            if(tTmp.equals(sTmp)) {
                answer = "yes";
            } else {
                answer = "no";
            }
        }
    }
    public static void output(int i) throws Exception{
        StringBuffer sb = new StringBuffer();
        sb.append("#").append(i).append(" ").append(answer).append("\n");
        bw.write(sb.toString());
    }
    public static void terminate() throws Exception {
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        tc = Integer.parseInt(br.readLine());
        for(int i = 1; i <= tc; i++) {
            input();
            sol();
            output(i);
        }
        terminate();
    }
}
