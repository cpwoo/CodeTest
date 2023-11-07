package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 카드짝맞추기 {
    private static int[] dr = {1,-1,0,0};
    private static int[] dc = {0,0,1,-1};

    private static List<int[]> orders;

    public int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        
        int n = 0;
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if (board[i][j] != 0) n++;
            }
        }
        n /= 2;

        int[] tmp = new int[n];
        for (int i=0; i<n; i++) {
            tmp[i] = i+1;
        }

        orders = new ArrayList<>();
        permutation(n, n, new int[n], tmp, 0, 0);

        for (int[] order : orders) {
            int total = 0;
            int[] point = new int[2];
            point[0] = r; point[1] = c;

            int[][] cBoard = new int[4][4];
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++) {
                    cBoard[i][j] = board[i][j];
                }
            }

            for (int card : order) {
                int cnt = 0;
                cnt += bfs(cBoard, card, point)+1;
                cBoard[point[0]][point[1]] = 0;
                
                cnt += bfs(cBoard, card, point)+1;
                cBoard[point[0]][point[1]] = 0;

                total += cnt;
            }

            answer = Math.min(answer, total);
        }

        return answer;
    }

    private void permutation(int n, int r, int[] perms, int[] input, int depth, int flag) {
        if (depth == r) {
            int[] tmp = perms.clone();
            orders.add(tmp);
            return;
        }

        for (int i=0; i<n; i++) {
            if ((flag&(1<<i)) == 0) {
                perms[depth] = input[i];
                permutation(n, r, perms, input, depth+1, flag|(1<<i));
            }
        }
    }

    private static int bfs(int[][] board, int target, int[] point) {
        int r = point[0], c = point[1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, 0});

        boolean[][] visited = new boolean[4][4];
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (board[p[0]][p[1]] == target) {
                point[0] = p[0]; point[1] = p[1];
                return p[2];
            }

            for (int d=0; d<4; d++) {
                int nr = p[0]+dr[d], nc = p[1]+dc[d];
                if (0 <= nr && nr < 4 && 0 <= nc && nc < 4 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, p[2]+1});
                }
            }

            for (int d=0; d<4; d++) {
                int[] result = findCard(board, p[0], p[1], d);
                if ((result[0] != p[0] || result[1] != p[1]) && !visited[result[0]][result[1]]) {
                    visited[result[0]][result[1]] = true;
                    q.add(new int[]{result[0], result[1], p[2]+1});
                }
            }
        }

        return 0;
    }

    private static int[] findCard(int[][] board, int r, int c, int d) {
        r += dr[d]; c += dc[d];
        while (0 <= r && r < 4 && 0 <= c && c < 4) {
            if (board[r][c] != 0) {
                return new int[]{r, c};
            }
            r += dr[d]; c += dc[d];
        }
        return new int[]{r-dr[d], c-dc[d]};
    }
}
