import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int[] arr;
    public static int answer;


    public static void input() throws Exception {
        answer = 0;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void algorithm() {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) continue;
            int[] tmp = {arr[i-2],arr[i-1],arr[i+1],arr[i+2]};
            Arrays.sort(tmp);
            if(arr[i] > tmp[3]) {
                answer += arr[i]-tmp[3];
            }
        }
    }

    public static void output(int tc) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(tc).append(" ").append(answer).append("\n");
        bw.write(sb.toString());
    }
    public static void terminate() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception{
        for (int i = 1; i <= 10; i++) {
            input();
            algorithm();
            output(i); 
        }
        terminate();
    }
}