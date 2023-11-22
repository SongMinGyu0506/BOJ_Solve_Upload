class Solution {
    public static void change(int start, int end, int[] answer) {
        if(end-1-start < answer[1]-answer[0]) {
            answer[0] = start;
            answer[1] = end-1;
        }
    }
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0,sequence.length-1};
        int start = 0;
        int end = 1;
        int sum = sequence[0];
        while(start < end) {
            if(sum == k) {
                change(start,end,answer);
                sum -= sequence[start++];
            } else if (sum > k) {
                sum -= sequence[start++];
            } else if (end < sequence.length) {
                sum += sequence[end++];
            } else {
                break;
            }
        }
        return answer;
    }
}