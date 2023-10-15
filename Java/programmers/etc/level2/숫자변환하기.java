package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 숫자변환하기 {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        int[] visited = new int[y+1];
        Arrays.fill(visited, -1);
        visited[x] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] tmp = new int[]{cur+n, cur*2, cur*3};
            for (int nxt : tmp) {
                if (nxt <= y && visited[nxt] == -1) {
                    visited[nxt] = visited[cur]+1;
                    q.add(nxt);
                }
            }
        }
        
        return visited[y];
    }
}
