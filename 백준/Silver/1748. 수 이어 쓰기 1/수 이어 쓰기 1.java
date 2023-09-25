import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        if (N < 10) {
            sb.append(N+"\n");
        } else {
            for(int i = 1; i <= N; i++) {
                if (i >= 1 && i < 10) result++;
                if (i >= 10 && i < 100) result+=2;
                if (i >= 100 && i < 1000) result+=3;
                if (i >= 1000 && i < 10000) result+=4;
                if (i >= 10000 && i < 100000) result+=5;
                if (i >= 100000 && i < 1000000) result+=6;
                if (i >= 1000000 && i < 10000000) result+=7;
                if (i >= 10000000 && i < 100000000) result+=8;
                if (i == 100000000) result+=9;
            }
            sb.append(result+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
