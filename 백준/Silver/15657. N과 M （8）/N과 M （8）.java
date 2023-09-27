import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuffer sb = new StringBuffer();
    public static int[] inputArr, resultArr;
    public static boolean[] visited;

    public static void Solution(int N, int M, int depth) {
        if(depth == M) {
            for (int i = 0; i < resultArr.length; i++) {
                sb.append(resultArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < inputArr.length; i++) {
            if(depth == 0) {
                resultArr[depth] = inputArr[i];
                Solution(N, M, depth+1);
            } else if(resultArr[depth-1] <= inputArr[i]) {
                resultArr[depth] = inputArr[i];
                Solution(N, M, depth+1);
            }
            
        }
    }
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        resultArr = new int[M];
        inputArr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputArr);
        Solution(N, M, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
