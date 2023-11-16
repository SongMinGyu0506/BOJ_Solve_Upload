import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t_c = sc.nextInt();
		for(int tc = 1; tc <= t_c; tc++) {
			int N = sc.nextInt();
			if(N%2 == 0) {
				System.out.println("#"+tc+" "+"Alice");
			} else {
				System.out.println("#"+tc+" "+"Bob");
			}
		}
	}
}