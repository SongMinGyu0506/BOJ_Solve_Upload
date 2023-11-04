import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc;

    public static LinkedList<Integer> data;

    public static void input() throws Exception {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        data = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }
    }

    public static void sol() throws Exception {
        int cnt = 1;
        while (true) {
            int target = data.remove();
            if(target-cnt <= 0) {
                data.add(0);
                break;
            }
            data.add(target-cnt);
            cnt++;
            if(cnt == 6) {
                cnt = 1;
            }
        }
    }
    
    public static void output(int tc) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("#").append(tc).append(" ");
        for (int i = 0; i < 7; i++) {
            sb.append(data.get(i)).append(" ");
        }
        sb.append(data.get(7)).append(" ");
        sb.append("\n");
        bw.write(sb.toString());
    }
    public static void terminate() throws Exception {
        bw.flush();
        bw.close();
        br.close();
    }
    public static void main(String[] args) throws Exception{
        for(int i = 1; i <= 10; i++) {
            input();
            sol();
            output(i);
        }
        terminate();
    }
}
