package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 경주로건설 {
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};

    public int solution(int[][] board) {
        int answer = 10000;
        int N = board.length;
        int[][][] dp = new int[4][N][N];

        for (int i=0; i<4; i++) {
            for (int j=0; j<N; j++) {
                Arrays.fill(dp[i][j], 10000);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,0});
        q.add(new int[]{0,0,0,1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], m = cur[2], d = cur[3];
            for (int i=0; i<4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == 0) {
                    int nm = m+1;
                    if (d != i) nm += 5;
                    if (nm < dp[i][nx][ny]) {
                        dp[i][nx][ny] = nm;
                        if (nx == N-1 && ny == N-1) continue;
                        q.add(new int[]{nx, ny, nm, i});
                    }
                }
            }
        }

        for (int i=0; i<4; i++) {
            answer = Math.min(answer, dp[i][N-1][N-1]);
        }

        return answer*100;
    }
}
