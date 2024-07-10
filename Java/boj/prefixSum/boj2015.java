package CodeTest.Java.boj.prefixSum;

import java.io.*;
import java.util.*;

public class boj2015 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int k = Integer.parseInt(inp[1]);

        int[] nums = new int[n];
        inp = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(inp[i]);
        }

        long cnt = 0;
        Map<Integer, Long> prefix = new HashMap<>();

        for(int i=1; i<n; i++) {
            nums[i] += nums[i-1];
        }

        for(int i=0; i<n; i++) {
            if(nums[i] == k) {
                cnt++;
            }
            cnt += prefix.getOrDefault(nums[i]-k,0L);
            prefix.put(nums[i], prefix.getOrDefault(nums[i],0L)+1);
        }

        bw.write(cnt+"");
    }

}
