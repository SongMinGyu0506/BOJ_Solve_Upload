import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int tc;
    public static int strLen;
    public static String str;

    public static void input() throws Exception{
        strLen = Integer.parseInt(br.readLine());
        str = br.readLine();
    }

    public static String algorithm() {
        int[] arrCnt = new int[27];
        for (int i = 0; i < strLen; i++) {
            int idx = str.charAt(i)-97;
            arrCnt[idx]++;
        }
        for (int i = 0; i < 27; i++) {
            if(arrCnt[i] % 2 == 1) return "No";
        }
        return "Yes";
    }

    public static void output(String answer, int tc) throws Exception {
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
            output(algorithm(),i);
        }
        terminate();
    }
}