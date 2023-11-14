import java.util.*;
import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int[] deck;
	public static int N,sum;
	public static String answer;
	
	public static void input() throws Exception {
		sum = 0;
		answer = "";
		deck = new int[12];
		for(int i = 2; i <= 11; i++) {
			if(i == 10) {
				deck[i] = 16;
			} else {
				deck[i] = 4;
			}
		}
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int t = Integer.parseInt(br.readLine());
			sum += t;
			deck[t]--;
		}
	}

	public static void sol() throws Exception {
		int targetScore = 21-sum;
		int cnt = 0;
		if(targetScore >= 11) {
			answer = "GAZUA";
			return;
		}
		for(int i = 2; i <= targetScore; i++) {
			cnt += deck[i];
		}
		int others = 0;
		for(int i = targetScore+1; i <= 11; i++) {
			others += deck[i];
		}
		if(cnt > others) {
			answer = "GAZUA";
		} else {
			answer = "STOP";
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