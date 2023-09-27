import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arrInput = new int[N+1];
        int[] memo = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arrInput[i] = sc.nextInt();
        }
        memo[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                //카드의 수 p(i)의 값을 하나씩 늘려보면서 비교한다.
                /**
                 * ex) 카드 장수가 2장 필요할 때,
                 * 이전에 계산한 카드 1장 소모값의 최댓값 + p(1) 비용
                 * 이전에 계산한 카드 0장 소모값의 최댓값(0) + p(2) 비용
                 * 
                 * ex) 카드 장수가 3장 필요할 때,
                 * 이전에 계산한 카드 2장 소모값의 최댓값 + p(1) 비용
                 * 이전에 계산한 카드 1장 소모값의 최댓값 + p(2) 비용
                 * 이전에 계산한 카드 0장 소모값의 최댓값 + p(3) 비용
                 * 
                 * 각각 계산하여 최댓값만 저장한다.
                 */
                memo[i] = Math.max(memo[i],memo[i-j]+arrInput[j]);
            }
        }
        System.out.println(memo[N]);
    }
}
