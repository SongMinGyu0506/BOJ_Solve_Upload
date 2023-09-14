import java.util.Scanner;

public class Main {
    static public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b,a%b);
    }
    static public int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(gcd(A, B));
        System.out.println(lcm(A, B));
    }
}