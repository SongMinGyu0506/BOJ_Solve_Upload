import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static String answer;
	
	public static int N,P;
	public static int[][] path;
	public static int[] answerMaps;
	
	public static void input() throws Exception {
		answer = "";
		N = Integer.parseInt(br.readLine());
		path = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			path[i][0] = A;
			path[i][1] = B;
		}
		P = Integer.parseInt(br.readLine());
		answerMaps = new int[5001];
	}
	
	public static void sol() throws Exception {
		for(int i = 0; i < path.length; i++) {
			for(int j = path[i][0]; j <= path[i][1]; j++) {
				answerMaps[j]++;
			}
		}
	}
	public static void output(int tc) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("#").append(tc).append(" ");
		for(int i = 0; i < P-1; i++) {
			int a = Integer.parseInt(br.readLine());
			sb.append(answerMaps[a]).append(" ");
		}
		int a = Integer.parseInt(br.readLine());
		sb.append(answerMaps[a]).append("\n");
		bw.write(sb.toString());
	}
	public static void terminate() throws Exception {
		bw.flush();
		bw.close();
		br.close();
	}
	public static void main(String[] args) throws Exception{
		int tc = Integer.parseInt(br.readLine());
		for(int i = 1; i <= tc; i++) {
			input();
			sol();
			output(i);
		}
		terminate();
	}

}