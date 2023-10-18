import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(visited,i,computers);
                answer++;
            }
        }
        
        
        return answer;
    }
    public static void bfs(boolean[] visited, int start, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            int current = queue.poll();
             for(int i = 0; i < computers[current].length; i++) {
                 if((computers[current][i] == 1) && !visited[i]) {
                     visited[i] = true;
                     queue.add(i);
                 }
             }
        }
    }
}