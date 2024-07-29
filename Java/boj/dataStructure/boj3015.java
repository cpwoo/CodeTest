package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj3015 {
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
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Stack<long[]> stack = new Stack<>();
        long ret = 0;

        for(long a: arr) {
            while(!stack.isEmpty() && stack.peek()[0] < a) {
                ret += stack.pop()[1];
            }

            if(stack.isEmpty()) {
                stack.add(new long[]{a, 1});
                continue;
            }

            if(stack.peek()[0] == a) {
                long cnt = stack.pop()[1];
                ret += cnt;

                if(!stack.isEmpty()) ret++;
                stack.add(new long[]{a, cnt+1});
            } else {
                stack.add(new long[]{a, 1});
                ret++;
            }
        }

        bw.write(ret+"");
    }

}
