package CodeTest.Java.boj.backtracking;

import java.io.*;
import java.util.*;

public class boj1799 {
    private static int[] dx = new int[]{-1,1,-1,1};
    private static int[] dy = new int[]{-1,-1,1,1};

    private static int N, answer;
    private static int[][] tmp;
    private static List<int[]> grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        int[][] board = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] inp = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(inp[j]);
            }
        }

        grid = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] != 0 && (i+j)%2 == 0) {
                    grid.add(new int[]{i, j});
                }
            }
        }
        tmp = new int[N][N];
        answer = 0;
        backtracking(0, 0);
        int res1 = answer;

        grid = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] != 0 && (i+j)%2 == 1) {
                    grid.add(new int[]{i, j});
                }
            }
        }
        tmp = new int[N][N];
        answer = 0;
        backtracking(0, 0);
        int res2 = answer;

        System.out.println(res1 + res2);
    }

    private static void backtracking(int idx, int cnt) {
        if(idx >= grid.size()) {
            answer = Math.max(answer, cnt);
            return;
        }
        int x = grid.get(idx)[0];
        int y = grid.get(idx)[1];

        if(tmp[x][y] == 0) {
            bishop(x, y, 1);
            backtracking(idx+1, cnt+1);
            bishop(x, y, -1);
            backtracking(idx+1, cnt);
        } else {
            backtracking(idx+1, cnt);
        }
    }

    private static void bishop(int x, int y, int num) {
        int nx, ny;
        for(int i=0; i<N; i++) {
            for(int d=0; d<4; d++) {
                nx = x + i*dx[d]; ny = y + i*dy[d];
                if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    tmp[nx][ny] += num;
                } 
            }
        }
    }

}
