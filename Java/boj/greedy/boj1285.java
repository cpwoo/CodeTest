package CodeTest.Java.boj.greedy;

import java.io.*;

public class boj1285 {
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
        
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) board[i] = br.readLine().toCharArray();

        int ret = n*n+1;

        char[][] tmp = new char[n][n];
        for(int f=0; f<(1<<n); f++) {
            for(int i=0; i<n; i++) for(int j=0; j<n; j++) tmp[i][j] = board[i][j];
            
            for(int i=0; i<n; i++) {
                if((f&(1<<i)) != 0) {
                    for(int j=0; j<n; j++) {
                        tmp[i][j] = (tmp[i][j] == 'H') ? 'T' : 'H';
                    }
                }
            }

            int tot = 0;
            for(int j=0; j<n; j++) {
                int cnt = 0;
                for(int i=0; i<n; i++) {
                    if(tmp[i][j] == 'T') cnt++;
                }
                tot += Math.min(cnt, n-cnt);
            }
            ret = Math.min(ret, tot);
        }

        bw.write(ret+"");
    }

}
