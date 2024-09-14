package CodeTest.Java.boj.graph;

import java.io.*;

public class boj10026 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    private static int n;
    private static char board[][];
    private static boolean visited[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        
        board = new char[n][n];
        for(int i=0; i<n; i++) board[i] = br.readLine().toCharArray();

        visited = new boolean[n][n];

        int threeCnt = 0;
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(!visited[i][j]) {
                dfs(i, j);
                threeCnt++;
            }
        }

        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(board[i][j] == 'G') board[i][j] = 'R';
        }

        visited = new boolean[n][n];

        int twoCnt = 0;
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(!visited[i][j]) {
                dfs(i, j);
                twoCnt++;
            }
        }

        bw.write(threeCnt+" "+twoCnt+"");
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int k=0; k<4; k++) {
            int nx = x+dx[k], ny = y+dy[k];
            if(0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny] && board[nx][ny] == board[x][y]) {
                dfs(nx, ny);
            }
        }
    }

}
