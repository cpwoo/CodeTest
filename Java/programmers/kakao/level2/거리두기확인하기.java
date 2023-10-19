package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 거리두기확인하기 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i=0; i<places.length; i++) {
            answer[i] = bfs(places[i]);
        }
        return answer;
    }
    
    private int bfs(String[] p) {
        List<int[]> start = new ArrayList<>();

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (p[i].charAt(j) == 'P') {
                    start.add(new int[]{i, j});
                }
            }
        }
        
        for (int[] s : start) {
            Queue<int[]> q = new LinkedList<>();
            q.add(s);
            boolean[][] visited = new boolean[5][5];
            int[][] distance = new int[5][5];
            visited[s[0]][s[1]] = true;
            
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                
                for (int d=0; d<4; d++) {
                    int nx = x+dx[d], ny = y+dy[d];
                    if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && !visited[nx][ny]) {
                        if (p[nx].charAt(ny) == 'O') {
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            distance[nx][ny] = distance[x][y]+1;
                        }
                        if (p[nx].charAt(ny) == 'P' && distance[x][y] <= 1) return 0;
                    }
                }
            }
        }
        
        return 1;
    }
}
