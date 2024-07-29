package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj11003 {
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
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Deque<long[]> q = new ArrayDeque<>();

        for(int i=0; i<N; i++) {
            while(!q.isEmpty() && q.peekLast()[0] > arr[i]) q.pollLast();
            while(!q.isEmpty() && q.peekFirst()[1] < i-L+1) q.pollFirst();
            q.add(new long[]{arr[i], i});
            bw.write(q.peekFirst()[0]+" ");
        }
    }

}
