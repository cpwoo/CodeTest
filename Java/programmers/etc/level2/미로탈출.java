package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 미로탈출 {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    
    public int solution(String[] tmp) {
        int row = tmp.length, col = tmp[0].length();
        String[][] maps = new String[row][col];
        for (int i=0; i<row; i++) {
            String[] str = tmp[i].split("");
            for (int j=0; j<col; j++) {
                maps[i][j] = str[j];
            }
        }
        
        int[][][] visited = new int[row][col][2];
        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (maps[i][j].equals("S")) {
                    sx = i; sy = j;
                } else if (maps[i][j].equals("L")) {
                    lx = i; ly = j;
                } else if (maps[i][j].equals("E")) {
                    ex = i; ey = j;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy][0] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], state = cur[2];
            for (int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col || maps[nx][ny].equals("X")) continue;
                if ((nx == lx && ny == ly) && state == 0 && visited[nx][ny][1] == 0) {
                    visited[nx][ny][1] = visited[x][y][0]+1;
                    q.add(new int[]{nx, ny, 1});
                }
                if (visited[nx][ny][state] == 0) {
                    visited[nx][ny][state] = visited[x][y][state]+1;
                    q.add(new int[]{nx, ny, state});
                }
            }
        }
        return visited[ex][ey][1]-1;
    }
}
