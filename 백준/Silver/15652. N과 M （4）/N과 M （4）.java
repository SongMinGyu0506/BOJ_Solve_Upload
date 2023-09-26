import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuffer sb = new StringBuffer();
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        Solution(N, M, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
    public static void Solution(int N, int M, int depth) {
        if(M == depth) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for ( int i = 1; i <= N; i++ ) {
            if (depth == 0) {
                arr[depth] = i;
                Solution(N, M, depth+1);
            } else {
                if (i >= arr[depth-1]) {
                    arr[depth] = i;
                    Solution(N, M, depth+1);
                }
            }
        }
    }
}
