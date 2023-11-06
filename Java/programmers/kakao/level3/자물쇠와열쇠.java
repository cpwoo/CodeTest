package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length, N = lock.length;
        
        int[][] board = new int[3*N][3*N];
        for (int[] row : board) {
            Arrays.fill(row, 1);
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                board[i+N][j+N] = lock[i][j];
            }
        }

        for (int i=0; i<4; i++) {
            rot90(key, M);
            for (int lock_ix=0; lock_ix<2*N; lock_ix++) {
                for (int lock_iy=0; lock_iy<2*N; lock_iy++) {
                    for (int key_ix=0; key_ix<M; key_ix++) {
                        for (int key_iy=0; key_iy<M; key_iy++) {
                            board[lock_ix+key_ix][lock_iy+key_iy] += key[key_ix][key_iy];
                        }
                    }
                    if (check(board, N)) return true;
                    for (int key_ix=0; key_ix<M; key_ix++) {
                        for (int key_iy=0; key_iy<M; key_iy++) {
                            board[lock_ix+key_ix][lock_iy+key_iy] -= key[key_ix][key_iy];
                        }
                    }
                }
            }
        }

        return false;
    }

    private static boolean check(int[][] board, int N) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (board[i+N][j+N] != 1) return false;
            }
        }
        return true;
    }

    private static void rot90(int[][] key, int M) {
        int[][] tmp = new int[M][M];

        for (int i=0; i<M; i++) {
            for (int j=0; j<M; j++) {
                tmp[i][j] = key[M-j-1][i];
            }
        }

        for (int i=0; i<M; i++) {
            for (int j=0; j<M; j++) {
                key[i][j] = tmp[i][j];
            }
        }
    }
}
