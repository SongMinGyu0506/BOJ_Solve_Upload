import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc;
    public static String str;
    public static String answer = "";

    public static void input() throws Exception {
        answer = "";
        str = br.readLine();
    }

    public static void algorithm() {
        //MMYY or YYMM
        // 0 < pre < 12 && 0 < post < 12 ==> AMBIGUOUS
        // 0 < pre < 12 && ((12 < post) || (post == 00)) ==> MMYY
        // ((12 < pre) || (pre == 00)) && 0 < post < 12 ==> YYMM

        String pre = "";
        String post = "";

        for (int i = 0; i < str.length(); i++) {
            if(i <= 1) {
                pre+=str.charAt(i);
            } else {
                post+=str.charAt(i);
            }
        }

        int preInt = Integer.parseInt(pre);
        int postInt = Integer.parseInt(post);

        if(((0 < preInt) && (preInt <= 12)) && ((0 < postInt) && (postInt <= 12))) {
            answer = "AMBIGUOUS";
        } else if (((0 < preInt) && (preInt <= 12)) && ((12 < postInt) || (post.equals("00")))) {
            answer = "MMYY";
        } else if (((12 < preInt) || (pre.equals("00"))) && ((0 < postInt) && (postInt <= 12))){
            answer = "YYMM";
        } else {
            answer = "NA";
        }
    }

    public static void output(int tc) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("#").append(tc).append(" ").append(answer).append("\n");
        bw.write(sb.toString());
    }

    public static void terminate() throws Exception{
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception{
        tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            input();
            algorithm();
            output(i);
        }
        terminate();
    }
}
