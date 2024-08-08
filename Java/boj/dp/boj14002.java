package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj14002 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=1; i<n; i++) for(int j=0; j<i; j++) {
            if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
        }

        int max = 0;
        for(int i=0; i<n; i++) max = Math.max(max, dp[i]);

        bw.write(max+"\n");

        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            if(dp[i] == max) {
                stack.add(arr[i]);
                max--;
            }
        }

        sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop()).append(' ');

        bw.write(sb.toString());
    }

}
