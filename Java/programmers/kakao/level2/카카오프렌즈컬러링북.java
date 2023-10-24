package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 카카오프렌즈컬러링북 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visited = new boolean[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    int p = picture[i][j];
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    int cnt = 1;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];
                        for (int d=0; d<4; d++) {
                            int nx = x+dx[d], ny = y+dy[d];
                            if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                                if (!visited[nx][ny] && picture[nx][ny] == p) {
                                    q.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                    cnt++;
                                }
                            }
                        }
                    }
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                }
            } 
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
