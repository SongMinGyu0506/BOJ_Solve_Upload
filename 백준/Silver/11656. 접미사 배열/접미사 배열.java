import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String input = br.readLine();
        String[] arr = new String[input.length()];
        for(int i = 0; i < input.length(); i++) {
            arr[i] = input.substring(i, input.length());
        }
        Arrays.sort(arr);
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
