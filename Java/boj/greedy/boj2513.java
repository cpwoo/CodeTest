package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj2513 {
    static class Info implements Comparable<Info> {
        int pos, cnt;
        Info(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info info) {
            if(this.pos != info.pos) return this.pos-info.pos;
            return this.cnt-info.cnt;
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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        List<Info> left = new ArrayList<>();
        List<Info> right = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            if(pos < S) left.add(new Info(pos, cnt));
            else right.add(new Info(pos, cnt));
        }

        Collections.sort(left);
        Collections.sort(right, Collections.reverseOrder());

        int answer = 0, bus = 0;
        for(Info l : left) {
            bus += l.cnt;
            while(bus > 0) {
                bus -= K;
                answer += (S-l.pos)*2;
            }
        }

        bus = 0;
        for(Info r : right) {
            bus += r.cnt;
            while(bus > 0) {
                bus -= K;
                answer += (r.pos-S)*2;
            }
        }

        bw.write(answer+"");
    }

}
