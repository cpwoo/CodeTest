package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1202 {
    static class Jew implements Comparable<Jew> {
        int m, v;
        Jew(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jew jew) {
            if(this.m != jew.m) return this.m-jew.m;
            return this.v-jew.v;
        }
    }

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

        PriorityQueue<Jew> jews = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jews.add(new Jew(m, v));
        }

        int[] bags = new int[k];
        for(int i=0; i<k; i++) bags[i] = Integer.parseInt(br.readLine());

        Arrays.sort(bags);

        long ret = 0;
        PriorityQueue<Integer> tmp = new PriorityQueue<>(Collections.reverseOrder());

        for(int bag : bags) {
            while(!jews.isEmpty() && bag >= jews.peek().m) {
                tmp.add(jews.poll().v);
            }
            if(!tmp.isEmpty()) ret += tmp.poll();
        }

        bw.write(ret+"");
    }

}
