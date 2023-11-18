import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int tc = 1; tc <= test_case; tc++) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            int cnt = 0;
            boolean[] maps = new boolean[N];
            for(int i = 0; i < N; i++) {
                if(!maps[i]) {
                    for(int j = i; j < i+2*D+1; j++) {
                        if(j >= maps.length) break;
                        maps[j] = true;
                    }
                    cnt++;
                }
            }
            StringBuffer sb = new StringBuffer();
            sb.append("#").append(tc).append(" ").append(cnt);
            System.out.println(sb);
        }
    }
}
