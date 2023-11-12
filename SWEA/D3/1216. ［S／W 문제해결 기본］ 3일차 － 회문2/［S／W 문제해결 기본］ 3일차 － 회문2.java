import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int tc,answer;
	public static char[][] maps;
	
	public static void input() throws Exception {
		answer = -10;
		tc = Integer.parseInt(br.readLine());
		maps = new char[100][100];
		for(int i = 0; i < 100; i++) {
			String s = br.readLine();
			for(int j = 0; j < 100; j++) {
				maps[i][j] = s.charAt(j);
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
		for(int i = 2; i <= 100; i++) {
			for(int j = 0; j < 100; j++) {
				StringBuffer s = new StringBuffer();
				for(int k = 0; k < 100; k++) {
					s.append(maps[j][k]);
					if(s.length() > i) {
						s.delete(0, 1);
					}
					if(s.length() == i && checker(s)) {
						if (answer < s.length()) {
							answer = s.length();
						}
					}
				}
			}
			for(int j = 0; j < 100; j++) {
				StringBuffer s = new StringBuffer();
				for(int k = 0; k < 100; k++) {
					s.append(maps[k][j]);
					if(s.length() > i) {
						s.delete(0, 1);
					}
					if(s.length() == i && checker(s)) {
						if (answer < s.length()) {
							answer = s.length();
						}
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
	public static void main(String[] args) throws Exception{
		for(int i = 1; i <= 10; i++) {
			input();
			sol();
			output(i);
		}
		terminate();
	}
}