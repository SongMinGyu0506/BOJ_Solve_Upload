import java.util.*;

class Solution {
    public int checker(String target, String[] want) {
        for(int i = 0; i < want.length; i++) {
            if(target.equals(want[i])) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean cntChekcer(int[] tmp_number) {
        for(int i = 0; i < tmp_number.length; i++) {
            if(tmp_number[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashSet<String> set = new HashSet<>(List.of(want));
        
        for(int i = 0; i <= discount.length-10; i++) {
            int[] tmp_number = new int[number.length];
            for(int j = 0; j < number.length; j++) {
                tmp_number[j] = number[j];
            }
            for(int j = i; j < 10+i; j++) {
                int checkNumber = checker(discount[j],want);
                if(checkNumber == -1) break;
                else {
                    tmp_number[checkNumber]--;
                }
            }
            if(cntChekcer(tmp_number)) {
                answer++;
            }
        }
        return answer;
    }
}