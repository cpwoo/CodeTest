package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1715 {
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
        
        Queue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<n; i++) q.add(Integer.parseInt(br.readLine()));

        int ret = 0;
        while(q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            ret += a+b;
            q.add(a+b);
        }

        bw.write(ret+"");
    }

}
