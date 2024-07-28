package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj2104 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Stack<long[]> stack = new Stack<>();
        long ans = 0;

        for(int i=0; i<n; i++) {
            long w = 0;
            while(!stack.isEmpty() && stack.peek()[0] > nums[i]) {
                long[] tmp = stack.pop();
                ans = Math.max(ans, tmp[0]*(w+tmp[1]));
                w += tmp[1];
            }
            stack.add(new long[]{nums[i], nums[i]+w});
        }

        long w = 0;
        while(!stack.isEmpty()) {
            long[] tmp = stack.pop();
            ans = Math.max(ans, tmp[0]*(w+tmp[1]));
            w += tmp[1];
        }

        bw.write(ans+"");
    }

}
