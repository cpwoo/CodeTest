package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj2493 {
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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty()) {
                if(stack.peek()[1] > arr[i]) {
                    answer.add(stack.peek()[0]+1);
                    break;
                } else {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                answer.add(0);
            }
            stack.add(new int[]{i, arr[i]});
        }

        for(int a: answer) {
            bw.write(a+" ");
        }
    }

}
