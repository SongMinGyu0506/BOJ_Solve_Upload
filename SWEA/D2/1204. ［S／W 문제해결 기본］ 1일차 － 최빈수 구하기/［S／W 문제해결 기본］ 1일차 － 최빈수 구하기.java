import java.util.*;
import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static HashMap<Integer,Integer> map;
	public static int answer;
	
	
	public static void input() throws Exception {
		map = new HashMap<>();
		answer = 0;
		String tc = br.readLine();
	}

	public static void sol() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		int current = 0;
		for(int i = 0; i < 1000; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(!map.containsKey(tmp)) {
				map.put(tmp, 1);
			} else {
				map.put(tmp, map.get(tmp)+1);
			}
			if(cnt < map.get(tmp)) {
				cnt = map.get(tmp);
				current = tmp;
			} else if (cnt == map.get(tmp)) {
				if(current < tmp) {
					current = tmp;
					cnt = map.get(tmp);
				}
			}
		}
		answer = current;
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