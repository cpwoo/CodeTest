package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj6987 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    
    private static int[][] game = {{0,1},{0,2},{0,3},{0,4},{0,5},{1,2},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5},{3,4},{3,5},{4,5}};
    private static int[][] result = {{0,2},{1,1},{2,0}};
    private static int ans, arr[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        for(int t=0; t<4; t++) {
            st = new StringTokenizer(br.readLine());
            arr = new int[6][3];
            for(int i=0; i<6; i++) {
                for(int j=0; j<3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = 0;
            dfs(0);
            bw.write(ans+" ");
        }
    }

    private static void dfs(int idx) {
        if(idx == 15) {
            ans = 1;
            for(int[] a: arr) {
                if(a[0] != 0 || a[1] != 0 || a[2] != 0) {
                    ans = 0;
                    break;
                }
            }
            return;
        }

        int p = game[idx][0], q = game[idx][1];
        for(int[] res: result) {
            int x = res[0], y = res[1];
            if(arr[p][x] > 0 && arr[q][y] > 0) {
                arr[p][x]--;
                arr[q][y]--;
                dfs(idx+1);
                arr[p][x]++;
                arr[q][y]++;
            }
        }
    }
}
