import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[12];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        
        /*
         * a(n) 값을 찾기 위해서는, a(n-1)+1, a(n-2)+2, a(n-3)+3을 수행한다면 a(n)의 조건을 찾을 수 있다. (a > 3)
         * 따라서 a(n-1)+a(n-2)+a(n-3)을 수행한다면 a(n) 값 탐색 완료
         */
        for (int i = 4; i <= 11; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            System.out.println(arr[a]);
        }
    }
}
