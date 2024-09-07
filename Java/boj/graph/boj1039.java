package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1039 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int ret, r;
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
        char[] num = st.nextToken().toCharArray();
        r = Integer.parseInt(st.nextToken());

        ret = -1;
        visited = new boolean[r+1][1000001];

        dfs(0, num, 0);

        bw.write(ret+"");
    }

    private static void dfs(int x, char[] num, int depth) {
        int n = 0;
        for(int i=0; i<num.length; i++) n = n*10+(num[i]-'0');

        if(visited[depth][n]) return;

        visited[depth][n] = true;

        if(depth == r) {
            ret = Math.max(ret, n);
            return;
        }

        for(int i=x; i<num.length; i++) for(int j=i+1; j<num.length; j++) {
            if(i == 0 && num[j] == '0') continue;
            swap(i, j, num);
            dfs(x, num, depth+1);
            swap(j, i, num);
        }
    }

    private static void swap(int a, int b, char[] num) {
        char tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }

}
