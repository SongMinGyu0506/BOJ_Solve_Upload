class Solution {
public int[] solution(int[] sequence, int k) {
        int[] answer = {Integer.MAX_VALUE,Integer.MAX_VALUE};
        int len = Integer.MAX_VALUE;
        
        int left = 0;
        int right = 0;
        
        int sum = sequence[0];
        while(left <= right && right < sequence.length) {
            if(sum == k) {
            	if(right-left <= len) {
            		if(right-left < len) {
            			len = right-left;
            			answer[0] = left;
            			answer[1] = right;
            		} else {
            			if(answer[0] > left && answer[1] > right) {
            				len = right-left;
            				answer[0] = left;
            				answer[1] = right;
            			}
            		}
            	}
                sum -= sequence[left];
                left++;
                continue;
            }
            if(sum > k) {
                sum -= sequence[left];
                left++;
            } else if(right+1 < sequence.length && sum < k) {
            	right++;
            	sum += sequence[right];
            } else {
            	sum -= sequence[left];
            	left++;
            }
        }
        return answer;
    }
}