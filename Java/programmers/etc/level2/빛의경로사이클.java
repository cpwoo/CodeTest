package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 빛의경로사이클 {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,-1,0,1};

    public List<Integer> solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        int N = grid.length, M = grid[0].length();
        boolean[][][] visited = new boolean[N][M][4];

        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++) {
                for (int d=0; d<4; d++) {
                    if (visited[y][x][d]) continue;
                    int cnt = 0;
                    int ny = y, nx = x;
                    while (!visited[ny][nx][d]) {
                        visited[ny][nx][d] = true;
                        cnt++;
                        if (grid[ny].charAt(nx) == 'L') d = (d+3)%4;
                        if (grid[ny].charAt(nx) == 'R') d = (d+1)%4;
                        ny = (ny+dy[d]+N)%N; nx = (nx+dx[d]+M)%M;
                    }
                    answer.add(cnt);
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
