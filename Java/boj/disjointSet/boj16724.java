package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj16724 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static char table[][];
    private static int n, m, group[][], idx, answer;

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

        table = new char[n][m];
        for(int i=0; i<n; i++) {
            table[i] = br.readLine().toCharArray();
        }

        group = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(group[i], -1);
        }

        idx = 0; answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                move(i, j, idx);
                idx++;
            }
        }
        
        bw.write(answer+"");
    }

    private static void move(int x, int y, int idx) {
        if(x < 0 || x >= n || y < 0 || y >= m) return;

        if(group[x][y] != -1) {
            if(group[x][y] == idx) answer++;
            return;
        }

        group[x][y] = idx;
        int d = -1;
        switch(table[x][y]) {
            case 'L': d = 0; break;
            case 'R': d = 1; break;
            case 'U': d = 2; break;
            case 'D': d = 3; break;
        }
        move(x+dx[d], y+dy[d], idx);
    }

}
