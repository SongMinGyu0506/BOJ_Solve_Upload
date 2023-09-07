import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        String T = br.readLine();

        StringBuffer sb = new StringBuffer();
        sb.append(backtraking(S, T)+"\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int backtraking(String start, String target) {
        if (start.length() == target.length()) {
            if (start.equals(target)) {
                return 1;
            }
            return 0;
        }

        int ans = 0;
        if (target.charAt(target.length()-1) == 'A') {
            ans += backtraking(start,target.substring(0, target.length()-1));
            
        } 
        if(target.charAt(0) == 'B') {
            String tmp = new StringBuffer(target.substring(1, target.length())).reverse().toString();
            ans += backtraking(start,tmp);
        }

        return ans > 0 ? 1 : 0;
    }
}
