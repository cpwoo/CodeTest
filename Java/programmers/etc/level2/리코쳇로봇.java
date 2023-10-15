package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 리코쳇로봇 {
    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};

    public int solution(String[] tmp) {
        int R = tmp.length, C = tmp[0].length();
        String[][] board = new String[R][C];
        
        for (int i=0; i<R; i++) {
            String[] row = tmp[i].split("");
            for (int j=0; j<C; j++) {
                board[i][j] = row[j];
            }
        }
        
        int[][] visited = new int[R][C];
        int cr = 0, cc = 0;
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (board[i][j].equals("R")) {
                    cr = i; cc = j;
                }
            }
        }
        
        visited[cr][cc] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{cr, cc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cr = cur[0]; cc = cur[1];
            if (board[cr][cc].equals("G")) {
                return visited[cr][cc]-1;
            }
            for (int d=0; d<4; d++) {
                int nr = cr, nc = cc;
                while (true) {
                    nr += dr[d]; nc += dc[d];
                    if ((nr >= 0 && nr < R) && (nc >= 0 && nc < C) && board[nr][nc].equals("D")) {
                        nr -= dr[d]; nc -= dc[d];
                        break;
                    }
                    if (!((nr >= 0 && nr < R) && (nc >= 0 && nc < C))) {
                        nr -= dr[d]; nc -= dc[d];
                        break;
                    }
                }
                
                if (visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[cr][cc]+1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }    
}
