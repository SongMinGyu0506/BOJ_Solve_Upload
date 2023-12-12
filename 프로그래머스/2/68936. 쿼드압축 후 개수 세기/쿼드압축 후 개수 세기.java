class Solution {
    
    public static void bi(int[][] arr, int sy, int sx, int size, int[] answer) {
        for(int y = sy; y < size+sy; y++) {
            for(int x = sx; x < size+sx; x++) {
                if(arr[y][x] != arr[sy][sx]) {
                    bi(arr,sy,sx,size/2,answer);
                    bi(arr,sy,sx+size/2,size/2,answer);
                    bi(arr,sy+size/2,sx,size/2,answer);
                    bi(arr,sy+size/2,sx+size/2,size/2,answer);
                    return;
                }
            }
        }
        if(arr[sy][sx] == 0) {
            answer[0]++;
        } else {
            answer[1]++;
        }
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = {0,0};
        bi(arr,0,0,arr.length,answer);
        return answer;
    }
}