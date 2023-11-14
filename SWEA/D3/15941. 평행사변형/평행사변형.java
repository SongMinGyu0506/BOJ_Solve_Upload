import java.util.Scanner;

public class Solution {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int tc = sc.nextInt();
	for(int i = 1; i <= tc; i++) {
		int a = sc.nextInt();
		System.out.println("#"+i+" "+a*a);
	}
}
}
