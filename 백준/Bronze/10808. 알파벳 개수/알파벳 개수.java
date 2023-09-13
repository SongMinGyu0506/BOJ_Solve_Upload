import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[27];
        String s = br.readLine();
        for(int i = 0; i < s.length(); i++) {
            arr[Character.getNumericValue(s.charAt(i))-10]++;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 25; i++) {
            sb.append(arr[i]+" ");
        }
        sb.append(arr[25]+"\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
