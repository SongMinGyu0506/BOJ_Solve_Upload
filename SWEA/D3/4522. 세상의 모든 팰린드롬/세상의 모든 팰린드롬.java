import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int tc;
    public static String answer,str;

    public static void input() throws Exception{
        answer = "";
        str = br.readLine();

    }
    public static String odd(String str) {
        int prePos = 0;
        int postPos = str.length()-1;
        while(prePos < postPos) {
            char preChar = str.charAt(prePos);
            char postChar = str.charAt(postPos);

            if(preChar != '?' && postChar != '?' && preChar != postChar) {
                return "Not exist";
            }

            prePos++;
            postPos--;
        }
        return "Exist";
    }
    public static String even(String str) {
        if(str.length() == 1) {
            return "Exist";
        }
        int cnt = 0;
        while (cnt != str.length()/2) {
            int pre = cnt;
            int post = str.length()-(1+cnt);

            char preChar = str.charAt(pre);
            char postChar = str.charAt(post);
            if(preChar != '?' && postChar != '?' && preChar != postChar) {
                return "Not exist";
            }
            cnt++;
        }
        return "Exist";
    }
    public static void sol() {
        if(str.length() % 2 == 0) {
            answer = odd(str);
        } else {
            answer = even(str);
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