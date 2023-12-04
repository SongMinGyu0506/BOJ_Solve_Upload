import java.util.*;

class Solution {
    public static ArrayList<int[]> list;
    public void hanoi(int depth, int start, int mid, int end) {
        if(depth == 1) {
            int[] result = {start,end};
            list.add(result);
            return;
        }
        hanoi(depth-1,start,end,mid);
        int[] result = {start,end};
        list.add(result);
        hanoi(depth-1,mid,start,end);
    }
    
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n,1,2,3);
        int[][] answer = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}