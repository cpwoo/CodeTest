package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj2836 {
    static class Taxi implements Comparable<Taxi> {
        int from, to;
        Taxi(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Taxi taxi) {
            if(this.from != taxi.from) return taxi.from-this.from;
            return taxi.to-this.to;
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
        int m = Integer.parseInt(st.nextToken());

        List<Taxi> lst = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a > b) lst.add(new Taxi(a, b));
        }

        Collections.sort(lst);

        long ret = m;
        int start = -1, end = -1;
        for(int i=0; i<lst.size(); i++) {
            Taxi taxi = lst.get(i);
            if(start == -1 && end == -1) {
                start = taxi.from; end = taxi.to;
            }
            else {
                if(taxi.from >= end) {
                    end = Math.min(end, taxi.to);
                }
                else {
                    ret += 2*(start-end);
                    start = taxi.from; end = taxi.to;
                }
            }
        }

        ret += 2*(start-end);

        bw.write(ret+"");
    }

}
