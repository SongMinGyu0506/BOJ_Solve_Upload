import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int tc,N,answer;
	public static char[][] maps;

	public static void input() throws Exception {
		answer = 0;
		N = Integer.parseInt(br.readLine());
		maps = new char[8][8];
		for(int i = 0; i < 8; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < tmp.length(); j++) {
				maps[i][j] = tmp.charAt(j);
			}
		}
	}
	public static boolean checker(StringBuffer sb) {
		String tmp1 = sb.toString();
		String tmp2 = sb.reverse().toString();
		sb.reverse();
		if(tmp1.equals(tmp2)) {
			return true;
		}
		return false;
	}
	public static void sol() throws Exception {
		for(int i = 0; i < 8; i++) {
			StringBuffer tmpBuf = new StringBuffer();
			for(int j = 0; j < 8; j++) {
				tmpBuf.append(maps[i][j]);
				if(tmpBuf.length() > N) {
					tmpBuf.delete(0, 1);
				}
				if(tmpBuf.length() == N && checker(tmpBuf)) {
					answer++;
				}
			}
		}
		for(int i = 0; i < 8; i++) {
			StringBuffer tmpBuf = new StringBuffer();
			for(int j = 0; j < 8; j++) {
				tmpBuf.append(maps[j][i]);
				if(tmpBuf.length() > N) {
					tmpBuf.delete(0, 1);
				}
				if(tmpBuf.length() == N && checker(tmpBuf)) {
					answer++;
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
		//tc = Integer.parseInt(br.readLine());
		for(int i = 1; i <= 10; i++) {
			input();
			sol();
			output(i);
		}
		terminate();
	}
}