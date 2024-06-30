package CodeTest.Java.boj.backtracking;

import java.io.*;
import java.util.*;

public class boj2580 {
    private static int[][] board;
    private static List<int[]> zeros;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        board = new int[9][9];
        zeros = new ArrayList<>();
        for(int r=0; r<9; r++) {
            String[] inp = br.readLine().split(" ");
            for(int c=0; c<9; c++) {
                board[r][c] = Integer.parseInt(inp[c]);
                if(board[r][c] == 0) {
                    zeros.add(new int[]{r, c});
                }
            }
        }

        dfs(0);
    }

    private static void dfs(int depth) {
        if(depth == zeros.size()) {
            for(int row=0; row<9; row++) {
                for(int col=0; col<9; col++) {
                    System.out.print(board[row][col] + " ");
                }
                System.out.println("");
            }
            System.exit(0);
        }
        
        int nr = zeros.get(depth)[0];
        int nc = zeros.get(depth)[1];

        for(int num=1; num<10; num++) {
            if(rowChk(nr, num) && colChk(nc, num) && squareChk(nr, nc, num)) {
                board[nr][nc] = num;
                dfs(depth+1);
                board[nr][nc] = 0;
            }
        }
    }

    private static boolean rowChk(int r, int num) {
        for(int c=0; c<9; c++) {
            if(board[r][c] == num) return false;
        }
        return true;
    }

    private static boolean colChk(int c, int num) {
        for(int r=0; r<9; r++) {
            if(board[r][c] == num) return false;
        }
        return true;
    }

    private static boolean squareChk(int r, int c, int num) {
        int nr = (r/3)*3, nc = (c/3)*3;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[nr+i][nc+j] == num) return false;
            }
        }
        return true;
    }   

}
