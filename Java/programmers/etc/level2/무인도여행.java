package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 무인도여행 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public List<Integer> solution(String[] tmp) {
        List<Integer> answer = new ArrayList<>();
        int R = tmp.length, C = tmp[0].length();
        String[][] maps = new String[R][C];
        
        for (int i=0; i<R; i++) {
            String[] row = tmp[i].split("");
            for (int j=0; j<C; j++) {
                maps[i][j] = row[j];
            }
        }
        
        int[][] visited = new int[R][C];
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (visited[i][j] == 0 && !maps[i][j].equals("X")) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    visited[i][j] = 1;
                    int cost = Integer.parseInt(maps[i][j]);
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];
                        for (int d=0; d<4; d++) {
                            int nx = x+dx[d], ny = y+dy[d];
                            if ((0 <= nx && nx < R) && (0 <= ny && ny < C)) {
                                if (visited[nx][ny] == 0 && !maps[nx][ny].equals("X")) {
                                    cost += Integer.parseInt(maps[nx][ny]);
                                    q.add(new int[]{nx,ny});
                                    visited[nx][ny] = 1;
                                }
                            }
                        }
                    }
                    answer.add(cost);
                }
            }
        }
        if (answer.isEmpty()) answer.add(-1);
        Collections.sort(answer);
        return answer;
    }
}
