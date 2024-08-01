package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1053 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static int dp[][];
    private static char arr[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        arr = br.readLine().toCharArray();
        int L = arr.length;

        dp = new int[L][L];
        for(int i=0; i<L; i++) Arrays.fill(dp[i], -1);

        int ret = recur(0, L-1);

        for(int i=0; i<L-1; i++) {
            for(int j=i+1; j<L; j++) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                
                dp = new int[L][L];
                for(int k=0; k<L; k++) Arrays.fill(dp[k], -1);

                ret = Math.min(ret, recur(0, L-1)+1);

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        bw.write(ret+"");
    }

    private static int recur(int left, int right) {
        if(left >= right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        int tmp = Integer.MAX_VALUE;
        if(arr[left] == arr[right]) tmp = recur(left+1, right-1);
        else tmp = Math.min(tmp, recur(left+1, right-1)+1);

        tmp = Math.min(tmp, Math.min(recur(left+1, right)+1, recur(left, right-1)+1));

        return dp[left][right] = tmp;
    }

}
