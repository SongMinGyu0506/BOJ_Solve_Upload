class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String numbers = "";
        int start = 0;
        for(int counter = 0; counter < t; counter++) {
            for(int people = 1; people <= m; people++) {
                numbers += Integer.toString(start,n);
                start++;
            }
            
        }
        for(int i = 0; i < numbers.length(); i++) {
            if(answer.length() == t) break;
            if(i%m == p-1) {
                answer += Character.toUpperCase(numbers.charAt(i));
            }
        }
        return answer;
    }
}