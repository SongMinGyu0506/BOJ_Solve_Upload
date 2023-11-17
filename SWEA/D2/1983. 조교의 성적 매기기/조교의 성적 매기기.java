import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int tc = 1; tc <= testCase; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] score = new int[N][3];
			double[][] people = new double[N][2];
			int[] scoreLimit = new int[10];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 3; j++) {
					score[i][j] = sc.nextInt();
				}
				people[i][0] = i+1;
				people[i][1] = (score[i][0]*0.35) + (score[i][1]*0.45) + (score[i][2]*0.2);
			}
			
			for(int i = 0; i < 10; i++) {
				scoreLimit[i] = N/10;
			}
			
			Arrays.sort(people, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					// TODO Auto-generated method stub
					return Double.compare(o2[1], o1[1]);
				}
			});
			int cnt = 0;
			String answer = "";
			for(double[] i : people) {
				if(i[0] == K) {
					if(cnt == 0) {
						answer = "A+";
					} else if (cnt == 1) {
						answer = "A0";
					} else if (cnt == 2) {
						answer = "A-";
					} else if (cnt == 3) {
						answer = "B+";
					} else if (cnt == 4) {
						answer = "B0";
					} else if (cnt == 5) {
						answer = "B-";
					} else if (cnt == 6) {
						answer = "C+";
					} else if (cnt == 7) {
						answer = "C0";
					} else if (cnt == 8) {
						answer = "C-";
					} else if (cnt == 9) {
						answer = "D0";
					}
				} else {
					scoreLimit[cnt]--;
					if(scoreLimit[cnt] == 0) {
						cnt++;
					}
				}
			}
			StringBuffer sb = new StringBuffer();
			sb.append("#").append(tc).append(" ").append(answer);
			System.out.println(sb.toString());
		}
	}
}