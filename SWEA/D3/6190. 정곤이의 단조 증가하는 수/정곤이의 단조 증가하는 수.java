import java.util.*;
import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int[] maps;
	public static int N;
	
	public static int answer;
	
	public static void input() throws Exception {
		answer = -1;
		N = Integer.parseInt(br.readLine());
		maps = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i <N; i++) {
			maps[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static boolean checker(String s) {
		for(int i = 0; i < s.length()-1; i++) {
			if(s.charAt(i) > s.charAt(i+1)) return false;
		}
		return true;
	}
	
	public static void sol() throws Exception {
		for(int i = 0; i < N; i++) {
			if(maps[i] % 10 == 0) continue;
			for(int j = i+1; j < N; j++) {
				if(maps[j] % 10 == 0 || (maps[i] * maps[j])%10 == 0) continue;
				if(checker(Integer.toString(maps[i]*maps[j]))) {
					if(answer < maps[i]*maps[j]) {
						answer = maps[i]*maps[j];
					}
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