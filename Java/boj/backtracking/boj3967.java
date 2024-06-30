package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj3967 {
    private static char[] star = new char[12];
    private static boolean[] visited = new boolean[12];
    private static final int tot = 4*'A'+22;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[][] board = new char[5][9];
        int idx = 0;
        
        for(int row=0; row<5; row++) {
            board[row] = br.readLine().toCharArray();
            for(int col=0; col<9; col++) {
                if(board[row][col] != '.') {
                    star[idx++] = board[row][col];
                    if(board[row][col] != 'x') {
                        visited[board[row][col]-'A'] = true;
                    }
                }
            }
        }

        solve(0);

        idx = 0;
        for(int row=0; row<5; row++) {
            for(int col=0; col<9; col++) {
                if(board[row][col] != '.') {
                    board[row][col] = star[idx++];
                }
                System.out.print(board[row][col]);
            }
            System.out.print("\n");
        }
    }

    private static boolean solve(int i) {
        if(i == 12) return true;

        if(star[i] != 'x') return solve(i+1);

        for(int j=0; j<12; j++) {
            if(!visited[j]) {
                visited[j] = true;
                star[i] = (char) (j+'A');
                if(!chk() || !solve(i+1)) {
                    visited[j] = false;
                    star[i] = 'x';
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean chk() {
        if(star[0] != 'x' && star[2] != 'x' && star[5] != 'x' && star[7] != 'x') {
            if(star[0]+star[2]+star[5]+star[7] != tot) return false;

        }
        if(star[1] != 'x' && star[2] != 'x' && star[3] != 'x' && star[4] != 'x') {
            if(star[1]+star[2]+star[3]+star[4] != tot) return false;

        }
        if(star[0] != 'x' && star[3] != 'x' && star[6] != 'x' && star[10] != 'x') {
            if(star[0]+star[3]+star[6]+star[10] != tot) return false;
        }
        if(star[7] != 'x' && star[8] != 'x' && star[9] != 'x' && star[10] != 'x') {
            if(star[7]+star[8]+star[9]+star[10] != tot) return false;
        }
        if(star[1] != 'x' && star[5] != 'x' && star[8] != 'x' && star[11] != 'x') {
            if(star[1]+star[5]+star[8]+star[11] != tot) return false;
        }
        if(star[4] != 'x' && star[6] != 'x' && star[9] != 'x' && star[11] != 'x') {
            if(star[4]+star[6]+star[9]+star[11] != tot) return false;
        }
        return true;
    }

}
