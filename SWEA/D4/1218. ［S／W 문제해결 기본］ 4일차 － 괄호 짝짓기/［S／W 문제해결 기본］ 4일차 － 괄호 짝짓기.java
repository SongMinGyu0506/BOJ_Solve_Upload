import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static String str;
    public static int strLength;


    public static void input() throws Exception{
        strLength = Integer.parseInt(br.readLine());
        str = br.readLine();
    }

    public static int sol() throws Exception {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if(tmp == '[' || tmp == '{' || tmp == '(' || tmp == '<') {
                stack.add(tmp);
                continue;
            }
            if((tmp == ']' && stack.peek() == '[') || 
            (tmp == '}' && stack.peek() == '{') || 
            (tmp == ')' && stack.peek() == '(') ||
            (tmp == '>' && stack.peek() == '<')) {
                stack.pop();
            } else {
                return 0;
            }
        }
        if(stack.empty()) return 1;
        else return 0;
    }

    public static void output(int tc) throws Exception{
        StringBuffer sb = new StringBuffer();
        sb.append("#").append(tc).append(" ").append(sol()).append("\n");
        bw.write(sb.toString());
    }

    public static void terminate() throws Exception {
        bw.flush();
        bw.close();
        br.close();
    }


    public static void main(String[] args) throws Exception{
        for (int tc = 1; tc <= 10; tc++) {
            input();
            output(tc);
        }
        terminate();
    }
}
