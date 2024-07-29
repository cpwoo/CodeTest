package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj6198 {
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
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        long ret = 0;
        for(int a: arr) {
            while(!stack.isEmpty() && stack.peek() <= a) {
                stack.pop();
            }
            stack.add(a);
            ret += stack.size()-1;
        }
        
        bw.write(ret+"");
    }

}
