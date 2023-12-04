class Solution {
    
    public int pointValue(int point) {
        if(point == 1 || point == 7) {
            return 3;
        } else if(point == 2 || point == 6) {
            return 2;
        } else if(point == 3 || point == 5) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public void maker(int[][] result, char target, int point) {
        if(target == 'R') {
            result[0][0] += pointValue(point);
        } else if(target == 'T') {
            result[0][1] += pointValue(point);
        } else if(target == 'C') {
            result[1][0] += pointValue(point);
        } else if(target == 'F') {
            result[1][1] += pointValue(point);
        } else if(target == 'J') {
            result[2][0] += pointValue(point);
        } else if(target == 'M') {
            result[2][1] += pointValue(point);
        } else if(target == 'A') {
            result[3][0] += pointValue(point);
        } else if(target == 'N') {
            result[3][1] += pointValue(point);
        }
    }
    
    public String resultMaker(int[][] result, int target) {
        if(target == 0) {
            if(result[0][0] >= result[0][1])
                return "R";
            else
                return "T";
        } else if(target == 1) {
            if(result[1][0] >= result[1][1])
                return "C";
            else
                return "F";
        } else if(target == 2) {
            if(result[2][0] >= result[2][1])
                return "J";
            else
                return "M";
        } else {
            if(result[3][0] >= result[3][1])
                return "A";
            else
                return "N";
        }
    }
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[][] result = new int[4][2];
        for(int c = 0; c < choices.length; c++) {
            char tmp = 'z';
            if(choices[c] < 4) {
                tmp = survey[c].charAt(0);
            } else if (choices[c] > 4) {
                tmp = survey[c].charAt(1);
            }
            maker(result,tmp,choices[c]);
        }
        
        for(int i = 0; i < result.length; i++) {
            answer += resultMaker(result,i);
        }
        
        return answer;
    }
}