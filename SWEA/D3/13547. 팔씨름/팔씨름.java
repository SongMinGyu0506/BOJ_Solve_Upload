import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int tc = 1; tc <= test_case; tc++) {
            String input = sc.next();
            int xCnt = 0;
            for(int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == 'x') {
                    xCnt++;
                }
            }
            StringBuffer sb = new StringBuffer();
            sb.append("#").append(tc).append(" ");
            if (xCnt >= 8) {
                sb.append("NO");
            } else {
                sb.append("YES");
            }
            System.out.println(sb.toString());
        }
    }
}
