import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> truckWeight = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            truckWeight.offer(Integer.parseInt(st.nextToken()));
        }
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < W; i++) {
            bridge.offer(0);
        }
        int weight = 0;
        int time = 0;
        while(true) {
            time++;
            weight -= bridge.poll();
            if(!truckWeight.isEmpty()) {
                if(truckWeight.peek()+weight <= L) {
                    weight += truckWeight.peek();
                    bridge.add(truckWeight.poll());
                } else {
                    bridge.add(0);
                }
            }
            if(bridge.isEmpty()) break;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(time+"\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
