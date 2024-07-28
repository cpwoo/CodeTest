package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj14391 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N, M, arr[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            String inp = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = inp.charAt(j)-'0';
            }
        }

        bw.write(bf()+"");
    }

    private static int bf() {
        int ret = 0;
        for(int i=0; i<(1<<(N*M)); i++) {
            int tot = 0;
            for(int row=0; row<N; row++) {
                int srow = 0;
                for(int col=0; col<M; col++) {
                    int idx = row*M+col;
                    if((i&(1<<idx)) != 0) {
                        srow = srow*10+arr[row][col];
                    } else {
                        tot += srow;
                        srow = 0;
                    }
                }
                tot += srow;
            }
            for(int col=0; col<M; col++) {
                int scol = 0;
                for(int row=0; row<N; row++) {
                    int idx = row*M+col;
                    if((i&(1<<idx)) == 0) {
                        scol = scol*10+arr[row][col];
                    } else {
                        tot += scol;
                        scol = 0;
                    }
                }
                tot += scol;
            }
            ret = Math.max(ret, tot);
        }

        return ret;
    }

}
