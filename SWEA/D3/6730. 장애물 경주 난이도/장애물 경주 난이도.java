import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int tc = 1; tc <= test_case; tc++) {
			int N = sc.nextInt();
			int maps[] = new int[N];
			for(int i = 0; i < N; i++) {
				maps[i] = sc.nextInt();
			}
			
			int desc = 0;
			int asc = 0;
			
			for(int i = 0; i < N-1; i++) {
				int tmp = maps[i]-maps[i+1];
				if(tmp < 0) {
					desc = Math.min(desc, tmp);
				} else {
					asc = Math.max(asc, tmp);
				}
			}
			StringBuffer sb = new StringBuffer();
			sb.append("#").append(tc).append(" ").append(Math.abs(desc)).append(" ").append(asc);
			System.out.println(sb.toString());
		}
	}
}