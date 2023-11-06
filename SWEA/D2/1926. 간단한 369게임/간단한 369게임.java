import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static ArrayList<String> answers;

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        answers = new ArrayList<>();
    }
    public static void sol() {
        for (int i = 1; i <= N; i++) {
            String tmp = String.valueOf(i);
            boolean switch369 = false;
            String str369 = "";
            for (int j = 0; j < tmp.length(); j++) {
                char s = tmp.charAt(j);
                if (s == '3' || s == '6' || s == '9') {
                    switch369 = true;
                    str369 += "-";
                }
            }
            if(!switch369) {
                answers.add(tmp);
            } else {
                answers.add(str369);
            }
        }
    }
    public static void output() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < answers.size()-1; i++) {
            sb.append(answers.get(i)).append(" ");
        }
        sb.append(answers.get(answers.size()-1)).append("\n");
        bw.write(sb.toString());
    }

    public static void terminate() throws Exception {
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception{
        input();
        sol();
        output();
        terminate();
    }
}
