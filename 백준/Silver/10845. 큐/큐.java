import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        int last = 0;
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if(command.contains("push")) {
                StringTokenizer st = new StringTokenizer(command);
                st.nextToken();
                last = Integer.parseInt(st.nextToken());
                queue.add(last);
            } else if (command.contains("pop")) {
                if(queue.isEmpty()) {
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(queue.poll()+"\n");
            } else if (command.contains("size")) {
                sb.append(queue.size()+"\n");
            } else if (command.contains("empty")) {
                if(queue.isEmpty()) {
                    sb.append(1+"\n");
                } else {
                    sb.append(0+"\n");
                }
            } else if (command.contains("front")) {
                if(queue.isEmpty()) {
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(queue.peek()+"\n");
            } else if (command.contains("back")) {
                if(queue.isEmpty()) {
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(last+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
