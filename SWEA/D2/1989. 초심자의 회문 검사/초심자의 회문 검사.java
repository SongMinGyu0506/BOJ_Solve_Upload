import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int tc = 1; tc <= testCase; tc++) {
			StringBuffer sb = new StringBuffer(sc.next());
			int answer;
			if(sb.toString().equals(sb.reverse().toString())) {
				answer = 1;
			} else {
				answer = 0;
			}
			sb = new StringBuffer();
			sb.append("#").append(tc).append(" ").append(answer);
			System.out.println(sb.toString());
		}
	}
}