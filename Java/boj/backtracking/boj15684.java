package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj15684 {
    private static int N, M, H, answer;
    private static boolean[][] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inp = br.readLine().split(" ");
        N = Integer.parseInt(inp[0]);
        M = Integer.parseInt(inp[1]);
        H = Integer.parseInt(inp[2]);

        v = new boolean[H][N];
        int a, b;

        for(int i=0; i<M; i++) {
            inp = br.readLine().split(" ");
            a = Integer.parseInt(inp[0]);
            b = Integer.parseInt(inp[1]);
            v[a-1][b-1] = true;            
        }

        answer = 4;
        dfs(0, 0, 0);
        bw.write(answer <= 3 ? answer+"" : "-1");

        bw.flush();
        bw.close();
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
