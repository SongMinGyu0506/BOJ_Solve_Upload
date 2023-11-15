import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i = 1; i <= tc; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] maps = new int[N][N];
			
			for(int k = 0; k < N; k++) {
				for(int j = 0; j < N; j++) {
					maps[k][j] = sc.nextInt();
				}
			}
			
			int answer = 0;
			for(int k = 0; k <= N-M; k++) {
				for(int j = 0; j <= N-M; j++) {
					int tmp = 0;
					for(int q1 = k; q1 < k+M; q1++) {
						for(int q2 = j; q2 < j+M; q2++) {
							tmp += maps[q1][q2];
						}
					}
					if(answer < tmp) {
						answer = tmp;
					}
				}
			}
			System.out.println("#"+i+" "+answer);
		}
	}
}
