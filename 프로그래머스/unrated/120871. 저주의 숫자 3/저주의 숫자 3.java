class Solution {
    public boolean checkNumber3(int cnt) {
        String tmp = String.valueOf(cnt);
        if(tmp.contains("3")) {
            return true;
        }
        return false;
    }
    public int solution(int n) {
        int answer = 0;
        int[] data = new int[101];
        int cnt = 1;
        int idx = 1;
        while(idx <= n) {
            if(cnt % 3 == 0 || checkNumber3(cnt)) {
                cnt++;
                continue;
            }
            data[idx] = cnt;
            idx++;
            cnt++;
        }
        return data[n];
    }
}