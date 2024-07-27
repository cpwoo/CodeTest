package CodeTest.Java.boj.bitmask;

import java.io.*;
import java.util.*;

public class boj10937 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static int n, value[], dp[][];
    private static int[][] score = {{100,70,40,0},{70,50,30,0},{40,30,20,0},{0,0,0,0}};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        value = new int[n*n];
        for(int i=0; i<n; i++) {
            String inp = br.readLine();
            for(int j=0; j<n; j++) {
                value[i*n+j] = inp.charAt(j)-'A';
                if(inp.charAt(j) == 'F') {
                    value[i*n+j] -= 2;
                }
            }
        }

        dp = new int[n*n][1<<n];
        for(int i=0; i<n*n; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(dfs(0,0)+"");
    }

    private static int dfs(int cur, int path) {
        if(cur >= n*n) return 0;

        if(dp[cur][path] != -1) return dp[cur][path];

        dp[cur][path] = 0;
        
        dp[cur][path] = Math.max(dp[cur][path], dfs(cur+1, path>>1));

        if((path&1) != 0) {
            dp[cur][path] = Math.max(dp[cur][path], dfs(cur+1, path>>1));
        } else {
            if(cur+n < n*n && (path&1) == 0) {
                dp[cur][path] = Math.max(dp[cur][path], 
                dfs(cur+1, (path>>1)|(1<<(n-1)))+score[value[cur]][value[cur+n]]);
            }
            if(cur%n != n-1 && (path&2) == 0) {
                dp[cur][path] = Math.max(dp[cur][path], 
                dfs(cur+2, path>>2)+score[value[cur]][value[cur+1]]);
            }
        }

        return dp[cur][path];
    }
    
}
