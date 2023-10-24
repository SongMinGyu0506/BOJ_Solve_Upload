import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int testCase;
    public static String memory;

    public static int answer = 0;
    
    public static void input() throws Exception{
        answer = 0;
        memory = br.readLine();
    }
    public static void sol() {
        String current = "";
        for (int i = 0; i < memory.length(); i++) {
            current += "0";
        }
        for (int i = 0; i < memory.length(); i++) {
            if(memory.charAt(i) != current.charAt(i)) {
                if(memory.charAt(i) == '1') {
                    current = current.substring(0,i);
                    for (int j = i; j < memory.length(); j++) {
                        current += '1';
                    }
                    answer++;
                } else {
                    current = current.substring(0, i);
                    for (int j = i; j < memory.length(); j++) {
                        current += '0';
                    }
                    answer++;
                }
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
        testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            input();
            sol();
            output(i);
        }
        terminate();
    }
}
