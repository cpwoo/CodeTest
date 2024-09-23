package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj20165 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int[] dr = {0,0,1,-1}, dc = {1,-1,0,0};

    private static int n, m, board[][], tmp;
    private static Map<Character, Integer> dmap;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        int[][] copy = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = copy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dmap = new HashMap<>();
        dmap.put('E', 0); dmap.put('W', 1);
        dmap.put('S', 2); dmap.put('N', 3);

        int total = 0;

        while(r-- > 0) {
            st = new StringTokenizer(br.readLine());
            int ar = Integer.parseInt(st.nextToken())-1;
            int ac = Integer.parseInt(st.nextToken())-1;
            char ad = st.nextToken().charAt(0);

            st = new StringTokenizer(br.readLine());
            int dr = Integer.parseInt(st.nextToken())-1;
            int dc = Integer.parseInt(st.nextToken())-1;

            tmp = 0;
            if(board[ar][ac] != 0) attack(ar, ac, ad, board[ar][ac]);

            board[dr][dc] = copy[dr][dc];
            total += tmp;
        }

        sb = new StringBuilder();
        sb.append(total).append('\n');

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append((board[i][j] != 0) ? 'S' : 'F').append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

    private static void attack(int sr, int sc, char sd, int len) {
        if(board[sr][sc] != 0) {
            board[sr][sc] = 0;
            tmp++;
        }
        for(int i=0; i<len-1; i++) {
            sr += dr[dmap.get(sd)];
            sc += dc[dmap.get(sd)];
            if(sr < 0 || sr >= n || sc < 0 || sc >= m) continue;
            attack(sr, sc, sd, board[sr][sc]);
        }
    }

}
