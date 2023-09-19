import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static String checker(String str) {
        Stack<Character> stack = new Stack<>();
        for(int j = 0; j < str.length(); j++) {
            if(str.charAt(j) == '(') {
                stack.push(str.charAt(j));
            } else {
                if (stack.empty()) {
                    return "NO";
                }
                if (stack.peek() == ')') {
                    stack.push(str.charAt(j));
                    continue;
                }
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        if(stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(checker(br.readLine())+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
