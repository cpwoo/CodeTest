package CodeTest.Java.boj.math;

import java.io.*;

public class boj2023 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static int n;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        dfs(2); dfs(3); dfs(5); dfs(7);

        bw.write(sb.toString());
    }

    private static void dfs(int num) {
        if(String.valueOf(num).length() == n) {
            sb.append(num).append('\n');
            return;
        }

        for(int i=0; i<10; i++) {
            int tmp = 10*num+i;
            if(chk(tmp)) dfs(tmp);
        }
    }

    private static boolean chk(int num) {
        for(int i=2; i<(int)Math.sqrt(num)+1; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

}
