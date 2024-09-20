package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj17135 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N, M, D, board[][], copy[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i=0; i<M; i++) for(int j=i+1; j<M; j++) for(int k=j+1; k<M; k++) {
            max = Math.max(max, simulation(new int[]{i, j, k}));
        }

        bw.write(max+"");
    }

    private static int simulation(int[] positions) {
        copy = new int[N][M];
        for(int y=0; y<N; y++) for(int x=0; x<M; x++) {
            copy[y][x] = board[y][x];
        }

        int killedAmount = 0;
        for(int y=N; y>0; y--) {
            List<int[]> killed = new ArrayList<>();
            for(int position : positions) {
                int[] killedEnemy = shoot(y, position);
                if(killedEnemy != null) killed.add(killedEnemy);
            }
            for(int[] killedEnemy : killed) {
                if(copy[killedEnemy[0]][killedEnemy[1]] == 1) {
                    copy[killedEnemy[0]][killedEnemy[1]] = 0;
                    killedAmount++;
                }
            }
        }

        return killedAmount;
    }

    private static int[] shoot(int y, int position) {
        for(int d=1; d<D+1; d++) {
            for(int left=d; left>=0; left--) {
                int height = d-left;
                if(height > 0 && 0 <= y-height && y-height < N && 0 <= position-left && position-left < M) {
                    if(copy[y-height][position-left] == 1) {
                        return new int[]{y-height, position-left};
                    }
                }
            }
            for(int right=1; right<d+1; right++) {
                int height = d-right;
                if(height > 0 && 0 <= y-height && y-height < N && 0 <= position+right && position+right < M) {
                    if(copy[y-height][position+right] == 1) {
                        return new int[]{y-height, position+right};
                    }
                }
            }
        }
        return null;
    }

}
