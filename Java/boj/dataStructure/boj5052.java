package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj5052 {
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
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] nums = new String[n];
            for(int i=0; i<n; i++) {
                nums[i] = br.readLine();
            }
            Arrays.sort(nums);

            boolean flag = true;
            for(int i=0; i<n-1; i++) {
                int len = nums[i].length();
                if(nums[i+1].length() >= len && nums[i].equals(nums[i+1].substring(0, len))) {
                    flag = false;
                    break;
                }
            }

            bw.write(flag ? "YES" : "NO");
            bw.write("\n");
        }   
    }

}
