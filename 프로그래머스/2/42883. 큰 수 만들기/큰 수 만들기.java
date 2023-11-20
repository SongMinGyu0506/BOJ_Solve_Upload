import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int maxLength = Math.abs(number.length()-k);
        
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++) {
            char tmp = number.charAt(i);
            if(stack.empty()) {
                stack.push(tmp);
                continue;
            }
            if(k > 0) {
                if(stack.peek() < tmp) {
                    while(!stack.empty() && stack.peek() < tmp && k > 0) {
                        k--;
                        stack.pop();
                    }
                    stack.push(tmp);
                } else {
                    stack.push(tmp);
                }
            } else {
                stack.push(tmp);
            }
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        while(!stack.empty()) {
            char tmp = stack.pop();
            answer = tmp+answer;
        }
        // String result = "";
        // for(int i = 0; i < answer.length()-k; i++) {
        //     result += answer.charAt(i);
        // }
        // return result;
        return answer;
    }
}