package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj17265 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {0,1}, dy = {1,0};
    private static int n, min, max;
    private static char arr[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for(int i=0; i<n; i++) { 
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        min = Integer.MAX_VALUE; max = Integer.MIN_VALUE;

        dfs(0, 0, arr[0][0]-'0');

        bw.write(max+" "+min+"");
    }

    private static void dfs(int x, int y, int p) {
        if(x == n-1 && y == n-1) {
            min = Math.min(min, p);
            max = Math.max(max, p);
            return;
        }

        for(int d=0; d<2; d++) {
            int nx = x+dx[d], ny = y+dy[d];
            if(nx == n || ny == n) continue;
            
            if(arr[x][y] == '*') dfs(nx, ny, p*(arr[nx][ny]-'0'));
            
            else if(arr[x][y] == '+') dfs(nx, ny, p+(arr[nx][ny]-'0'));

            else if(arr[x][y] == '-') dfs(nx, ny, p-(arr[nx][ny]-'0'));

            else dfs(nx, ny, p);
        }
    }

}
