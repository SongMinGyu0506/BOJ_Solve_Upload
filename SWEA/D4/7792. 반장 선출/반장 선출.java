import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc;
    public static int cnt;
    public static int N;
    public static String answer;
    public static String[] arr;


    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        answer = "";
        arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
    }

    public static void algo() throws Exception {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] checker = new int[27];
            int tmp = 0;
            for (int j = 0; j < arr[i].length(); j++) {
                if(arr[i].charAt(j) != ' ') {
                    if(checker[arr[i].charAt(j)-65] == 0) {
                        checker[arr[i].charAt(j)-65]++;
                    }
                }
                
            }
            for (int j = 0; j < checker.length; j++) {
                tmp += checker[j];
            }
            if (sum < tmp) {
                sum = tmp;
                answer = arr[i];
            } else if (sum == tmp) {
                String[] tmpStr = {answer,arr[i]};
                Arrays.sort(tmpStr);
                sum = tmp;
                answer = tmpStr[0];
            }
        }

    }

    public static void output(int tc) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(tc).append(" ").append(answer).append("\n");
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
            algo();
            output(i);
        }
        terminate();
    }
}
