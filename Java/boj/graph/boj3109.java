package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj3109 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int[] dy = {-1,0,1};

    private static int r, c;
    private static char table[][];
    private static boolean visited[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        table = new char[r][c];
        for(int i=0; i<r; i++) table[i] = br.readLine().toCharArray();

        visited = new boolean[r][c];

        int ret = 0;
        for(int i=0; i<r; i++) {
            if(table[i][0] == '.') {
                if(dfs(i, 0)) ret++;
            }
        }

        bw.write(ret+"");
    }

    private static boolean dfs(int i, int j) {
        if(j == c-1) return true;

        for(int d : dy) {
            if(0 <= i+d && i+d < r && table[i+d][j+1] == '.' && !visited[i+d][j+1]) {
                visited[i+d][j+1] = true;
                if(dfs(i+d, j+1)) return true;
            }
        }

        return false;
    }

}
