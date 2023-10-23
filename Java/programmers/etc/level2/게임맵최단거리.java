package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 게임맵최단거리 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        int[][] visited = new int[n][m];
        visited[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (visited[nx][ny] == 0 && maps[nx][ny] != 0) {
                        visited[nx][ny] = visited[x][y]+1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return visited[n-1][m-1] != 0 ? visited[n-1][m-1] : -1;
    }
}
