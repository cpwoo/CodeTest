package CodeTest.Java.boj.bitmask;

import java.io.*;
import java.util.*;

public class boj1657 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, m, value[], dp[][];
    private static int[][] score = {{10,8,7,5,1},{8,6,4,3,1},{7,4,3,2,1},{5,3,2,2,1},{1,1,1,1,0}};

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

        value = new int[n*m];
        for(int i=0; i<n; i++) {
            String inp = br.readLine();
            for(int j=0; j<m; j++) {
                value[i*m+j] = inp.charAt(j)-'A';
                if(inp.charAt(j) == 'F') {
                    value[i*m+j]--;
                }
            }
        }

        dp = new int[n*m][1<<m];
        for(int i=0; i<n*m; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(dfs(0,0)+"");
    }

    private static int dfs(int cur, int path) {
        if(cur >= n*m) return 0;

        if(dp[cur][path] != -1) return dp[cur][path];

        dp[cur][path] = 0;
        
        dp[cur][path] = Math.max(dp[cur][path], dfs(cur+1, path>>1));

        if((path&1) != 0) {
            dp[cur][path] = Math.max(dp[cur][path], dfs(cur+1, path>>1));
        } else {
            if(cur+m < n*m && (path&1) == 0) {
                dp[cur][path] = Math.max(dp[cur][path], 
                dfs(cur+1, (path>>1)|(1<<(m-1)))+score[value[cur]][value[cur+m]]);
            }
            if(cur%m != m-1 && (path&2) == 0) {
                dp[cur][path] = Math.max(dp[cur][path], 
                dfs(cur+2, path>>2)+score[value[cur]][value[cur+1]]);
            }
        }

        return dp[cur][path];
    }

}
