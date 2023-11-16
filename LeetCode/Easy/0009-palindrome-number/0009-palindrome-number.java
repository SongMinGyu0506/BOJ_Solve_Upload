import java.util.*;

class Solution {
    public boolean isPalindrome(int x) {
        StringBuffer sb = new StringBuffer(Integer.toString(x));
        if(sb.toString().equals(sb.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }
}