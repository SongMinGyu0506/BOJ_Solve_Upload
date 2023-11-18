import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int tc = 1; tc <= test_case; tc++) {
            StringBuffer sb = new StringBuffer();
            sb.append("#").append(tc).append(" ");
            String input = sc.next();
            int[] alphabet = new int[27];
            for(int i = 0; i < input.length(); i++) {
                char tmp = input.charAt(i);
                alphabet[tmp-'a']++;
            }
            String answerString = "";
            for(int i = 0; i < alphabet.length; i++) {
                if(alphabet[i] % 2 == 1) {
                    char aa = (char)(i+97);
                    answerString += String.valueOf(aa);
                }
            }
            if(answerString.equals("")) {
                sb.append("Good");
            } else {
                char[] answerCharArr = answerString.toCharArray();
                Arrays.sort(answerCharArr);
                answerString = new String(answerCharArr);
                sb.append(answerString);
            }
            System.out.println(sb);
        }
    }
}