import java.io.*;
import java.util.*;

public class Main {
    public static HashSet<String> hashSet = new HashSet<>();
    public static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            String inputString = br.readLine();
            hashSet.add(inputString);
        }
        for(int j=0; j<M; j++) {
            String checkString = br.readLine();
            if(hashSet.contains(checkString)) {
                result++;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(result+"\n");
        // sb.append(Solution(N, M)+"\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
