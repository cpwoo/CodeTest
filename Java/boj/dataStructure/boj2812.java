package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj2812 {
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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String inp = br.readLine();
        
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for(int i=0; i<n; i++) {
            while(cnt < k && !stack.isEmpty() && stack.peek() < inp.charAt(i)-'0') {
                stack.pop();
                cnt++;
            }
            stack.add(inp.charAt(i)-'0');
        }

        int idx = 0;
        for(int i: stack) {
            if(idx++ < n-k) {
                bw.write(i+"");
            }
        }
    }

}
