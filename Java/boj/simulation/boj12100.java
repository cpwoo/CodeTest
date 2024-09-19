package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj12100 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, ret;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        ret = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                ret = Math.max(ret, board[i][j]);
            }
        }

        dfs(0, board);

        bw.write(ret+"");
    }

    private static void dfs(int cnt, int[][] board) {
        if(cnt == 5) {
            for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
                if(board[i][j] > ret) ret = board[i][j];
            }
            return;
        }

        for(int d=0; d<4; d++) {
            int[][] tmp = new int[n][n];
            for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
                tmp[i][j] = board[i][j];
            }

            search(tmp, d);

            dfs(cnt+1, tmp);
        }
    }

    private static void search(int[][] v, int d) {
        int idx, x;

        switch(d) {
            case 0: {
                for(int j=0; j<n; j++) {
                    idx = 0;
                    for(int i=1; i<n; i++) {
                        if(v[i][j] != 0) {
                            x = v[i][j];
                            v[i][j] = 0;

                            if(v[idx][j] == 0) v[idx][j] = x;
                            else if(v[idx][j] == x) v[idx++][j] *= 2;
                            else v[++idx][j] = x;
                        }
                    }
                }
                break;
            }
            case 1: {
                for(int j=0; j<n; j++) {
                    idx = n-1;
                    for(int i=n-2; i>=0; i--) {
                        if(v[i][j] != 0) {
                            x = v[i][j];
                            v[i][j] = 0;
                            
                            if(v[idx][j] == 0) v[idx][j] = x;
                            else if(v[idx][j] == x) v[idx--][j] *= 2;
                            else v[--idx][j] = x;
                        }
                    }
                }
                break;
            }
            case 2: {
                for(int i=0; i<n; i++) {
                    idx = 0;
                    for(int j=1; j<n; j++) {
                        if(v[i][j] != 0) {
                            x = v[i][j];
                            v[i][j] = 0;

                            if(v[i][idx] == 0) v[i][idx] = x;
                            else if(v[i][idx] == x) v[i][idx++] *= 2;
                            else v[i][++idx] = x;
                        }
                    }
                }
                break;
            }
            case 3: {
                for(int i=0; i<n; i++) {
                    idx = n-1;
                    for(int j=n-2; j>=0; j--) {
                        if(v[i][j] != 0) {
                            x = v[i][j];
                            v[i][j] = 0;
                            
                            if(v[i][idx] == 0) v[i][idx] = x;
                            else if(v[i][idx] == x) v[i][idx--] *= 2;
                            else v[i][--idx] = x;
                        }
                    }
                }
                break;
            }
        }
    }
}
