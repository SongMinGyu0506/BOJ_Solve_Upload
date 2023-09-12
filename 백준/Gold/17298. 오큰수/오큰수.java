import java.util.*;
import java.io.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Solution()+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    /*
     * 문제 해결 방법 : 타겟의 값(스택 PEEK)보다 작은 값이라면 스택에 인덱스를 삽입
     * 스택이 비어있지 않고 타겟의 값보다 큰 값이 등장했다면 스택 내부의 인덱스를 전부 조사한다.
     * 그 때 arr[stack.peek()] < arr[i] 조건을 충족한다면 '오큰수' 이므로 오큰수로 값을 전부 바꾼다.
     * 이 과정을 거치고, 스택에 남은 값들은 오큰수가 없으므로 -1로 바꾼다.
     */
    public static String Solution() {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while(!stack.empty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.empty()) {
            arr[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(' ');
		}
        return sb.toString();
    }
}
