import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int tc = 1; tc <= test_case; tc++) {
			int N = sc.nextInt();
			String tmp = "";
			StringBuffer sb = new StringBuffer();
			sb.append("#").append(tc).append("\n");
			for(int i = 0; i < N; i++) {
				String a = sc.next();
				int b = sc.nextInt();
				for(int j = 0; j < b; j++) {
					tmp += a;
					if(tmp.length() % 10 == 0) {
						sb.append(tmp).append("\n");
						tmp = "";
					}
				}
			}
			sb.append(tmp);
			System.out.println(sb.toString());
		}
	}
}