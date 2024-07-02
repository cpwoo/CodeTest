package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj16987 {
    private static int n, answer;
    private static int[][] egg;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        egg = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] inp = br.readLine().split(" ");
            for(int j=0; j<2; j++) {
                egg[i][j] = Integer.parseInt(inp[j]);
            }
        }

        answer = 0;

        dfs(0);

        bw.write(answer+"");

        bw.flush();
        bw.close();
    }

    private static void dfs(int idx) {
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(egg[i][0] < 1) cnt++;
        }

        if(idx == n) {
            answer = Math.max(answer, cnt);
            return;
        }

        if(egg[idx][0] < 1) {
            dfs(idx+1);
            return;
        }

        if(cnt >= n-1) {
            answer = Math.max(answer, n-1);
            return;
        }

        for(int target=0; target<n; target++) {
            if(target != idx && egg[target][0] > 0) {
                egg[target][0] -= egg[idx][1];
                egg[idx][0] -= egg[target][1];
                dfs(idx+1);
                egg[target][0] += egg[idx][1];
                egg[idx][0] += egg[target][1];
            }
        }
    }
    
}
