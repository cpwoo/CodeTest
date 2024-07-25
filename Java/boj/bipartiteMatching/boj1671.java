package CodeTest.Java.boj.bipartiteMatching;

import java.io.*;
import java.util.*;

public class boj1671 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, d[];
    private static boolean prey[][], v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        int[][] predator = new int[n+1][3];
        
        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                predator[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        prey = new boolean[n+1][n+1];
        d = new int[n+1];

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(i == j) continue;
                if(
                    predator[i][0] == predator[j][0] &&
                    predator[i][1] == predator[j][1] &&
                    predator[i][2] == predator[j][2] && i > j) continue;
                if(
                    predator[i][0] >= predator[j][0] && 
                    predator[i][1] >= predator[j][1] && 
                    predator[i][2] >= predator[j][2]) prey[i][j] = true;
            }
        }

        for(int k=0; k<2; k++) {
            for(int i=1; i<n+1; i++) {
                v = new boolean[n+1];
                dfs(i);
            }
        }

        int ret = 0;
        for(int i=1; i<n+1; i++) {
            ret += (d[i] == 0) ? 1 : 0;
        }

        bw.write(ret+"");
    }

    private static boolean dfs(int i) {
        if(v[i]) return false;
        v[i] = true;

        for(int j=1; j<n+1; j++) {
            if(prey[i][j]) {
                if(d[j] == 0 || dfs(d[j])) {
                    d[j] = i;
                    return true;
                }
            }
        }

        return false;
    }

}
