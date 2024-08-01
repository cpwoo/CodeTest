package CodeTest.Java.boj.divideNconquer;

import java.io.*;
import java.util.*;

public class boj1725 {
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
        int[] data = new int[n];
        for(int i=0; i<n; i++) data[i] = Integer.parseInt(br.readLine());

        long ret = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && data[stack.peek()] > data[i]) {
                int height = data[stack.peek()];
                stack.pop();

                int width = i;
                if(!stack.isEmpty()) width = i-stack.peek()-1;

                ret = Math.max(ret, width*height);
            }
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            int height = data[stack.peek()];
            stack.pop();

            int width = n;
            if(!stack.isEmpty()) width = n-stack.peek()-1;

            ret = Math.max(ret, width*height);
        }

        bw.write(ret+"");
    }

}
