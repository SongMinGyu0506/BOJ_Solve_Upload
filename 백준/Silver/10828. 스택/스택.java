import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String command = br.readLine();
            if(command.contains("push")) {
                StringTokenizer st = new StringTokenizer(command);
                String com = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if (command.contains("pop")) {
                if (stack.empty()) {
                    sb.append(-1+"\n");
                    continue;
                } else {
                    sb.append(stack.pop()+"\n");
                }
            } else if (command.contains("size")) {
                sb.append(stack.size()+"\n");
            } else if (command.contains("empty")) {
                if (stack.empty()) {
                    sb.append(1+"\n");
                } else {
                    sb.append(0+"\n");
                }
            } else {
                if (stack.empty()) {
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(stack.peek()+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}