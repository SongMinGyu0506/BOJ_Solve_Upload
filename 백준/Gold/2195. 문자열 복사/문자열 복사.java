import java.io.*;
import java.util.*;

public class Main {
    public static int result = 0;
    public static String S = "";
    public static String P = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S = br.readLine();
        P = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(Solution(S,P)+"\n");

        bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
    }

    public static int Solution(String S, String P) {
        int idx = 0;
        for (int i = 0; i < P.length(); i++) {
            if(S.indexOf(P.substring(idx, i+1)) != -1) continue;
            result++;
            idx = i;
        }
        return result+1;
    }
}