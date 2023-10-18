import java.util.*;
class Node {
    public int cnt;
    public String word;
    
    public Node(int cnt, String word) {
        this.cnt = cnt;
        this.word = word;
    }
}
class Solution {
    
    public static int wordsLength = 0;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        wordsLength = words.length;
        answer = bfs(begin,words,target);
        return answer;
    }
    
    public static int bfs(String start, String[] words, String target) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordsLength+1];
        queue.add(new Node(0,start));
        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            
            String currentWord = tmp.word;
            int cnt = tmp.cnt;
            if(target.equals(currentWord)) {
                return cnt;
            }

            for(int i = 0; i < wordsLength; i++) {
                int tmpWordCnt = 0;
                for(int j = 0; j<currentWord.length(); j++) {
                    if(currentWord.charAt(j) != words[i].charAt(j)) {
                        tmpWordCnt++;
                    }
                }
                if((tmpWordCnt == 1) && !visited[i]) {
                    visited[i] = true;
                    queue.add(new Node(cnt+1,words[i]));
                }
            }
        }
        return 0;
    }
}