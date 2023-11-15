import java.util.*;
import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	
	public static int P,Q,R,S,W,answer;
	
	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
	}

	public static void sol() throws Exception {
		int b1 = P*W;
		int b2 = 0;
		if(R >= W) {
			b2 = Q;
		} else {
			int tmp = W-R;
			b2 = Q+tmp*S;
		}
		answer = Math.min(b1, b2);
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

	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			input();
			sol();
			output(i);
		}
		terminate();
	}
}