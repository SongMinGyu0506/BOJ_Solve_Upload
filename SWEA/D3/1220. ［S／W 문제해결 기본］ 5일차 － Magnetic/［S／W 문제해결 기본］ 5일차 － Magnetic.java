import java.util.*;
import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int[][] maps;
	public static int answer;
	
	public static void input() throws Exception {
		answer = 0;
		int N = Integer.parseInt(br.readLine());
		maps = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void sol() throws Exception {
		for(int x = 0; x < 100; x++) {
			Deque<Integer> deque = new ArrayDeque<>();
			for(int y = 0; y < 100; y++) {
				if(maps[y][x] != 0) {
					deque.add(maps[y][x]);
				}
			}
			while(deque.peek() == 2) {
				deque.removeFirst();
			}
			while(deque.peekLast() == 1) {
				deque.removeLast();
			}
			Deque<Integer> tmpDeque = new ArrayDeque<>();
			while(!deque.isEmpty()) {
				if(tmpDeque.isEmpty()) {
					tmpDeque.add(deque.removeFirst());
					continue;
				}
				if(tmpDeque.peekLast() != deque.peek()) {
					tmpDeque.add(deque.removeFirst());
				} else {
					deque.removeFirst();
				}
			}
			answer += tmpDeque.size()/2;
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
		int tc = 10;
		for (int i = 1; i <= tc; i++) {
			input();
			sol();
			output(i);
		}
		terminate();
	}
}