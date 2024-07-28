package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj2666 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, m, door1, door2, ans, arr[];
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        door1 = Integer.parseInt(st.nextToken());
        door2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        arr = new int[m];
        for(int i=0; i<m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        ans = Integer.MAX_VALUE;

        dfs(door1, door2, 0, 0);

        bw.write(ans+"");
    }

    private static void dfs(int door1, int door2, int depth, int cnt) {
        if(depth == m) {
            ans = Math.min(ans, cnt);
            return;
        }

        int tmp1 = Math.abs(door1-arr[depth]);
        int tmp2 = Math.abs(door2-arr[depth]);

        dfs(arr[depth], door2, depth+1, cnt+tmp1);
        dfs(door1, arr[depth], depth+1, cnt+tmp2);
    }

}
