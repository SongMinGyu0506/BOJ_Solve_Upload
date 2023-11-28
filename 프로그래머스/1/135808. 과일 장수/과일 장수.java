import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < score.length; i++) {
            stack.push(score[i]);
        }
        
        while(stack.size() >= m) {
            int scr = Integer.MAX_VALUE;
            int cnt = 0;
            for(int i = 0; i < m; i++) {
                int tmp = stack.pop();
                if(scr > tmp) {
                    scr = tmp;
                }
                cnt++;
            }
            answer += scr*cnt;
        }
        return answer;
    }
}