import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i = 1; i<= tc; i++) {
			long N = sc.nextInt();
			long a = (N*(N+1))/2;
			long b = N*N;
			long c = N*N+N;	
			System.out.println("#"+i+" "+a+" "+b+" "+c);
		}
	}
}
