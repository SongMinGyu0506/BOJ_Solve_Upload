import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp;
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        int width = -1;
        int height = -1;
        for(int i = 0; i < sizes.length; i++) {
            if(width < sizes[i][0]) width = sizes[i][0];
            if(height < sizes[i][1]) height = sizes[i][1];
        }
        answer = width * height;
        return answer;
    }
}