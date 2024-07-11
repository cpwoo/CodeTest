package CodeTest.Java.boj.prefixSum;

import java.io.*;

public class boj2571 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[100][100];
        
        for(int k=0; k<n; k++) {
            String[] inp = br.readLine().split(" ");
            int x = Integer.parseInt(inp[0]);
            int y = Integer.parseInt(inp[1]);

            for(int i=x; i<x+10; i++) {
                for(int j=y; j<y+10; j++) {
                    board[i][j] = 1;
                }
            }
        }

        for(int i=0; i<99; i++) {
            for(int j=0; j<100; j++) {
                if(board[i][j] != 0 && board[i+1][j] != 0) {
                    board[i+1][j] = board[i][j]+1;
                }
            }
        }
        
        int ret = 0;
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                int h = 100;
                for(int k=j; k<100; k++) {
                    h = Math.min(h, board[i][k]);
                    if(h == 0) break;
                    ret = Math.max(ret, h*(k-j+1));
                }
            }
        }

        bw.write(ret+"");
    }

}
