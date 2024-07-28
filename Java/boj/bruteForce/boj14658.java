package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj14658 {
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] star = new int[K][2];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                star[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int ret = 0;
        for(int i=0; i<K; i++) {
            for(int j=0; j<K; j++) {
                int cnt = 0;
                for(int k=0; k<K; k++) {
                    if(star[i][0] <= star[k][0] && star[k][0] <= star[i][0]+L && star[j][1] <= star[k][1] && star[k][1] <= star[j][1]+L) {
                        cnt++;
                    }
                }
                ret = Math.max(ret, cnt);
            }
        }

        bw.write(K-ret+"");
    }

}
