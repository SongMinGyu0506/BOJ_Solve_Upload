import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int X1,Y1,X2,Y2,N,tc;

    public static int[] answer;

    public static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        X1 = Integer.parseInt(st.nextToken());
        Y1 = Integer.parseInt(st.nextToken());
        X2 = Integer.parseInt(st.nextToken());
        Y2 = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        answer = new int[3];
    }
    public static void sol() throws Exception {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if((X1 <= x) && (x <= X2) && (Y1 <= y) && (y <= Y2)) {
                if (x == X1 || x == X2 || y == Y1 || y == Y2) {
                    answer[1]++;
                } else {
                    answer[0]++;
                }
            } else {
                answer[2]++;
            }
        }
    }

    public static void output(int tc) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("#").append(tc).append(" ");
        for (int i = 0; i < answer.length-1; i++) {
            sb.append(answer[i]).append(" ");
        }
        sb.append(answer[answer.length-1]).append("\n");
        bw.write(sb.toString());
    }
    public static void terminate() throws Exception {
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception{
        tc = Integer.parseInt(br.readLine());
        for(int i = 1; i <= tc; i++) {
            input();
            sol();
            output(i);
        }
        terminate();
    }
}
