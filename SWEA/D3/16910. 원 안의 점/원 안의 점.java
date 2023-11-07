import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 1; i <= tc; i++) {
            int answer = 0;
            int N = sc.nextInt();
            for (int j = -N; j <= N; j++) {
                for (int j2 = -N; j2 <= N; j2++) {
                    if(Math.pow(j,2)+Math.pow(j2,2) <= Math.pow(N, 2)) {
                        answer++;
                    }
                }
            }
            System.out.println("#"+i+" "+answer);
        }
    }
}