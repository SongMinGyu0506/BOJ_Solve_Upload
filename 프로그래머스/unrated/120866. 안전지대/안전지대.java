class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dy = {0,0,-1,1,1,1,-1,-1};
        int[] dx = {1,-1,0,0,1,-1,1,-1};
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    for(int k = 0; k < 8; k++) {
                        int ny = i+dy[k];
                        int nx = j+dx[k];
                        if((0 <= ny) && (ny < board.length) && (0 <= nx) && (nx < board.length)) {
                            if(board[ny][nx] == 0) {
                                board[ny][nx] = 2;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}