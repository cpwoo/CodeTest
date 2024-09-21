package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj18808 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N, M, R, C;
    private static boolean notebook[][], sticker[][];

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
        int K = Integer.parseInt(st.nextToken());
        
        notebook = new boolean[N][M];

        for(int t=0; t<K; t++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            sticker = new boolean[R][C];
            for(int i=0; i<R; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<C; j++) {
                    sticker[i][j] = (st.nextToken().equals("1"));
                }
            }

            for(int i=0; i<4; i++) {
                if(find()) break;
                else {
                    sticker = turn();
                    int tmp = R;
                    R = C;
                    C = tmp;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<N; i++) for(int j=0; j<M; j++) {
            sum += notebook[i][j] ? 1 : 0;
        }

        bw.write(sum+"");
    }

    private static boolean find() {
        for(int i=0; i<N-R+1; i++) for(int j=0; j<M-C+1; j++) {
            if(isMatching(i, j)) return true;
        }
        return false;
    }

    private static boolean isMatching(int x, int y) {
        for(int i=x; i<x+R; i++) for(int j=y; j<y+C; j++) {
            if(notebook[i][j] && sticker[i-x][j-y]) return false;
        }
        for(int i=x; i<x+R; i++) for(int j=y; j<y+C; j++) {
            if(sticker[i-x][j-y]) notebook[i][j] = true;
        }
        return true;
    }

    private static boolean[][] turn() {
        boolean[][] tmp = new boolean[C][R];
        for(int i=0; i<R; i++) for(int j=0; j<C; j++) {
            tmp[j][R-i-1] = sticker[i][j];
        }
        return tmp;
    }

}
