package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj17281 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N, data[][], answer, players[];
    private static boolean v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        N = Integer.parseInt(br.readLine());
        data = new int[N][10];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<10; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        players = new int[10];
        players[4] = 1;
        v = new boolean[10];
        v[1] = true;
        dfs(1);

        bw.write(answer+"");
    }

    private static void dfs(int num) {
        if(num > 9) {
            answer = Math.max(answer, game());
            return;
        }

        if(num == 4) dfs(num+1);
        else {
            for(int i=1; i<10; i++) {
                if(!v[i]) {
                    players[num] = i;
                    v[i] = true;

                    dfs(num+1);

                    v[i] = false;
                    players[num] = 0;
                }
            }
        }
    }

    private static int game() {
        int score = 0, idx = 1;
        for(int inning=1; inning<N+1; inning++) {
            int outCount = 0;
            int base1 = 0, base2 = 0, base3 = 0;
            while(outCount < 3) {
                int hit = data[inning-1][players[idx]];
                if(hit == 0) outCount++;
                else if(hit == 1) {
                    score += base3;
                    base3 = base2; base2 = base1; base1 = 1;
                }
                else if(hit == 2) {
                    score += (base2+base3);
                    base3 = base1; base2 = 1; base1 = 0;
                }
                else if(hit == 3) {
                    score += (base1+base2+base3);
                    base3 = 1; base2 = 0; base1 = 0;
                }
                else if(hit == 4) {
                    score += (base1+base2+base3+1);
                    base3 = 0; base2 = 0; base1 = 0;
                }
                idx++;
                if(idx > 9) idx = 1;
            }
        }
        return score;
    }

}
