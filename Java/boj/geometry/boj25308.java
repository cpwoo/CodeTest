package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj25308 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int arr[], v[], ret;
    private static boolean visited[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        arr = new int[8];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<8; i++) arr[i] = Integer.parseInt(st.nextToken());

        v = new int[8];
        visited = new boolean[8];

        ret = 0;
        dfs(0);

        bw.write(ret+"");
    }

    private static void dfs(int cnt) {
        if(cnt == 8) {
            ret += check();
            return;
        }
        for(int i=0; i<8; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            v[cnt] = arr[i];
            dfs(cnt+1);
            visited[i] = false;
        }
    }

    private static int check() {
        for(int i=0; i<8; i++) {
            int a = i, b = (i+1)%8, c = (i+2)%8;
            if(v[a]*v[c]*Math.sqrt(2) > v[b]*(v[a]+v[c])) return 0;
        }
        return 1;
    }

}
