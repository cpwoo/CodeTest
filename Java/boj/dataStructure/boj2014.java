package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj2014 {
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
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] prime = new long[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            prime[i] = Long.parseLong(st.nextToken());
        }

        PriorityQueue<Long> q = new PriorityQueue<>();
        for(long p: prime) q.add(p);

        for(int i=0; i<n-1; i++) {
            long num = q.poll();
            for(int j=0; j<k; j++) {
                q.add(num*prime[j]);
                if(num%prime[j] == 0) break;
            }
        }

        bw.write(q.peek()+"");
    }

}
