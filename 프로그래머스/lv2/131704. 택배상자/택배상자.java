import java.util.*;

class Solution {
    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subBelt = new Stack<>();
        int current = 1;
        for(int now: order) {
            if (now > current) {
                for(int i = current; i < now; i++) {
                    subBelt.push(i);
                }
                current = now+1;
                answer++;
                continue;
            }
            else if(now == current) {
                answer++;
                current++;
                continue;
            }
            else {
                if(!subBelt.isEmpty() && (subBelt.peek() == now)) {
                    subBelt.pop();
                    answer++;
                    continue;
                }
            }
            break;
        }
        return answer;
    }
}