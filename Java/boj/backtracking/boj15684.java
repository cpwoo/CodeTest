package CodeTest.Java.boj.backtracking;

import java.io.*;
import java.util.*;

public class boj15684 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N, M, H, answer;
    private static boolean[][] v;

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
        H = Integer.parseInt(st.nextToken());

        v = new boolean[H][N];
        int a, b;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            v[a-1][b-1] = true;            
        }

        answer = 4;
        dfs(0, 0, 0);
        bw.write(answer <= 3 ? answer+"" : "-1");
    }

    private static void dfs(int cnt, int x, int y) {
        if(answer <= cnt) return;
        
        if(check()) {
            answer = Math.min(answer, cnt);
            return;
        }

        if(cnt == 3) return;

        int k;
        for(int i=x; i<H; i++) {
            k = (i == x) ? y : 0;
            for(int j=k; j<N-1; j++) {
                if(!v[i][j]) {
                    v[i][j] = true;
                    dfs(cnt+1, i, j+2);
                    v[i][j] = false;
                }
            }
        }
    }

    private static boolean check() {
        int tmp;

        for(int i=0; i<N; i++) {
            tmp = i;
            for(int j=0; j<H; j++) {
                if(v[j][tmp]) {
                    tmp++;
                } else if(tmp > 0 && v[j][tmp-1]) {
                    tmp--;
                }
            }
            if(tmp != i) return false;
        }
        
        return true;
    }
        
}
