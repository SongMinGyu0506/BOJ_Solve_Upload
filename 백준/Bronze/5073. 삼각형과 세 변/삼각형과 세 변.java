import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = br.readLine();
            if(input.equals("0 0 0")) break;
            StringTokenizer st = new StringTokenizer(input);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int MAX = (A > B) ? ((A > C) ? A : C) : ((B > C) ? B : C);
            if (A == B && B == C) {
                System.out.println("Equilateral");
            }
            else if (MAX == A) {
                if (A >= B+C) {
                    System.out.println("Invalid");
                } else if (A == B || A == C || B == C) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            } else if (MAX == B) {
                if (B >= A+C) {
                    System.out.println("Invalid");
                } else if (B == A || B == C || A == C) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            } else if (MAX == C) {
                if (C >= A+B) {
                    System.out.println("Invalid");
                } else if (C == A || C == B || A == B) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            }
        }
    }
}
