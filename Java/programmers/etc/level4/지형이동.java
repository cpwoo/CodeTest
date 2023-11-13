package CodeTest.Java.programmers.etc.level4;

import java.util.*;

class Land implements Comparable<Land> {
    int x, y, cost;
    
    Land(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Land o) {
        return this.cost-o.cost;
    }
}

public class 지형이동 {
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public int solution(int[][] land, int height) {
        int N = land.length;
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Land> q = new PriorityQueue<>();
        q.add(new Land(0, 0, 0));
        
        int answer = 0;

        while (!q.isEmpty()) {
            Land cur = q.poll();
            int x = cur.x, y = cur.y, cost = cur.cost;
            
            if (visited[x][y]) continue;
            visited[x][y] = true;
            answer += cost;

            for (int d=0; d<4; d++) {
                int nx = x+dx[d], ny = y+dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    if (Math.abs(land[nx][ny]-land[x][y]) > height) {
                        q.add(new Land(nx, ny, Math.abs(land[nx][ny]-land[x][y])));
                    } else {
                        q.add(new Land(nx, ny, 0));
                    }
                }
            }
        }

        return answer;
    }   
}
