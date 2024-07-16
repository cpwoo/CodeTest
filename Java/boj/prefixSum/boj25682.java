package CodeTest.Java.boj.prefixSum;

import java.io.*;
import java.util.*;

public class boj25682 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for(int i=0; i<n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[][] s = new int[n+1][m+1];

        for(int r=1; r<n+1; r++) {
            for(int c=1; c<m+1; c++) {
                if((r+c)%2 == 0) {
                    if(board[r-1][c-1] == 'B') {
                        s[r][c] = s[r-1][c]+s[r][c-1]-s[r-1][c-1];
                    } else {
                        s[r][c] = s[r-1][c]+s[r][c-1]-s[r-1][c-1]+1;
                    }
                } else {
                    if(board[r-1][c-1] == 'W') {
                        s[r][c] = s[r-1][c]+s[r][c-1]-s[r-1][c-1];
                    } else {
                        s[r][c] = s[r-1][c]+s[r][c-1]-s[r-1][c-1]+1;
                    }
                }
            }
        }

        int _max = Integer.MIN_VALUE;
        int _min = Integer.MAX_VALUE;

        for(int r=k; r<n+1; r++) {
            for(int c=k; c<m+1; c++) {
                _max = Math.max(_max, s[r][c]-s[r-k][c]-s[r][c-k]+s[r-k][c-k]);
                _min = Math.min(_min, s[r][c]-s[r-k][c]-s[r][c-k]+s[r-k][c-k]);
            }
        }

        bw.write(Math.min(Math.min(_min, _max), Math.min(k*k-_min, k*k-_max))+"");
    }

}
