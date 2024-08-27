package CodeTest.Java.boj.greedy;

import java.io.*;

public class boj14939 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int[] dx = {-1,1,0,0,0};
    private static final int[] dy = {0,0,0,-1,1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        boolean[][] table = new boolean[10][10];
        for(int i=0; i<10; i++) {
            String inp = br.readLine();
            for(int j=0; j<10; j++) {
                table[i][j] = (inp.charAt(j) == 'O');
            }
        }

        int ret = 101;

        boolean[][] a;
        for(int f=0; f<(1<<10); f++) {
            a = new boolean[10][10];
            for(int i=0; i<10; i++) for(int j=0; j<10; j++) a[i][j] = table[i][j];

            int cnt = 0;

            for(int x=0; x<10; x++) {
                if((f&(1<<x)) != 0) {
                    cnt++;
                    for(int k=0; k<5; k++) {
                        int nx = x+dx[k], ny = 0+dy[k];
                        if(0 <= nx && nx < 10 && 0 <= ny && ny < 10) {
                            a[ny][nx] = !a[ny][nx];
                        }
                    }
                }
            }

            for(int y=1; y<10; y++) {
                for(int x=0; x<10; x++) {
                    if(!a[y-1][x]) continue;
                    for(int k=0; k<5; k++) {
                        int nx = x+dx[k], ny = y+dy[k];
                        if(0 <= nx && nx < 10 && 0 <= ny && ny < 10) {
                            a[ny][nx] = !a[ny][nx];
                        }
                    }
                    cnt++;
                }
            }

            boolean flag = true;
            for(int i=0; i<10; i++) if(a[9][i]) flag = false;

            if(flag) ret = Math.min(ret, cnt);
        }

        bw.write((ret != 101) ? ret+"" : "-1");
    }
}
