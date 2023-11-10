import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int tc;
    public static HashSet<Character> noHole = new HashSet<>(Arrays.asList('C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
    public static HashSet<Character> oneHole = new HashSet<>(Arrays.asList('A','D','O','P','Q','R'));
    public static HashSet<Character> twoHole = new HashSet<>(Arrays.asList('B'));

    public static String answer;
    public static String A;
    public static String B;

    public static void input() throws Exception {
        answer = "";
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();
    }

    public static Boolean checker(String A, String B) {
        for (int i = 0; i < A.length(); i++) {
           char a = A.charAt(i);
           char b = B.charAt(i);
           if(noHole.contains(a) && noHole.contains(b)) {
               continue;
           }
           if(oneHole.contains(a) && oneHole.contains(b)) {
               continue;
           }
           if(twoHole.contains(a) && twoHole.contains(b)) {
               continue;
           }
           return false;
        }
        return true;
    }

    public static void sol() throws Exception {
        if(A.length() != B.length()) {
            answer = "DIFF";
            return;
        }
        if(checker(A,B)) {
            answer = "SAME";
        } else {
            answer = "DIFF";
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
