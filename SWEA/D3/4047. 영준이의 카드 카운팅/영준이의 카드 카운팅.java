import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int tc;
    public static String str;

    public static String answer;
    public static int[] answers;
    public static int[] S,D,H,C;


    public static void input() throws Exception {
        answer = "";
        str = br.readLine();
        answers = new int[4];

        S = new int[14];
        D = new int[14];
        H = new int[14];
        C = new int[14];
    }

    public static void sol() {
        int strCnt = 0;
        while(strCnt < str.length()) {
            if(str.charAt(strCnt) == 'S') {
                String number = "";
                strCnt++;
                number += str.charAt(strCnt);
                strCnt++;
                number += str.charAt(strCnt);
                int numInt = Integer.parseInt(number);

                if(S[numInt] >= 1) {
                    answer = "ERROR";
                    return;
                }
                S[numInt]++;
            } else if(str.charAt(strCnt) == 'D') {
                String number = "";
                strCnt++;
                number += str.charAt(strCnt);
                strCnt++;
                number += str.charAt(strCnt);
                int numInt = Integer.parseInt(number);

                if(D[numInt] >= 1) {
                    answer = "ERROR";
                    return;
                }
                D[numInt]++;
            } else if(str.charAt(strCnt) == 'H') {
                String number = "";
                strCnt++;
                number += str.charAt(strCnt);
                strCnt++;
                number += str.charAt(strCnt);
                int numInt = Integer.parseInt(number);

                if(H[numInt] >= 1) {
                    answer = "ERROR";
                    return;
                }
                H[numInt]++;
            } else {
                String number = "";
                strCnt++;
                number += str.charAt(strCnt);
                strCnt++;
                number += str.charAt(strCnt);
                int numInt = Integer.parseInt(number);

                if(C[numInt] >= 1) {
                    answer = "ERROR";
                    return;
                }
                C[numInt]++;
            }
            strCnt++;
        }
        for (int i = 0; i < S.length; i++) {
            if(i == 0) continue;
            if(S[i] == 0) {
                answers[0]++;
            }
        }
        for (int i = 0; i < D.length; i++) {
            if(i == 0) continue;
            if(D[i] == 0) {
                answers[1]++;
            }
        }
        for (int i = 0; i < H.length; i++) {
            if(i == 0) continue;
            if(H[i] == 0) {
                answers[2]++;
            }
        }
        for (int i = 0; i < C.length; i++) {
            if(i == 0) continue;
            if(C[i] == 0) {
                answers[3]++;
            }
        }
    }

    public static void output(int tc) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("#").append(tc).append(" ");
        if(answer.equals("ERROR")) {
            sb.append(answer).append("\n");
        } else {
            for (int i = 0; i < answers.length-1; i++) {
                sb.append(answers[i]).append(" ");
            }
            sb.append(answers[answers.length-1]).append("\n");
        }
        bw.write(sb.toString());
    }

    public static void terminate() throws Exception {
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        tc = Integer.parseInt(br.readLine());
        for(int i = 1; i <= tc; i++) {
            input();
            sol();
            output(i);
        }
        terminate();
    }
}
