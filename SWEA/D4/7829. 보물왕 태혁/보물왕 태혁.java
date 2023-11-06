import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc,P;
    public static String str;
    
    public static int answer;

    public static void input() throws Exception {
        answer = 0;
        P = Integer.parseInt(br.readLine());
        str = br.readLine();
    }
    public static void sol() throws Exception {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            if(max < tmp) {
                max = tmp;
            }
            if(min > tmp) {
                min = tmp;
            }
        }
        answer = min*max;
    }

    public static void main(String[] args) throws Exception{
        tc = Integer.parseInt(br.readLine());
        for(int i = 1; i <= tc; i++) {
            input();
            sol();
            System.out.println("#"+i+" "+answer);
        }
    }
}
