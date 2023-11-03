import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int tc;
    public static int[][] maps;
    public static int answer;

    public static void input() throws Exception {
        answer = 0;
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                maps[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
    }

    public static void sol() {
        int key = N/2;
        for (int i = 0; i < N; i++) {
            if (i == key) {
                for (int j = 0; j < maps.length; j++) {
                    answer += maps[i][j];
                }
            } else if (i < key) {
                for (int j = key-(i); j <= key+(i); j++) {
                    answer += maps[i][j];
                }
            } else {
                for (int j = key-((N%i)-1); j <= key+((N%i)-1); j++) {
                    answer += maps[i][j];
                }
            }
        }
    }

    public static void output(int tc) throws Exception {
        StringBuffer sb = new StringBuffer();
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
            sol();
            output(i);
        }
        terminate();
    }
}
