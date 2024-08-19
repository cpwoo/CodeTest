package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj2457 {
    static class Flower implements Comparable<Flower> {
        int start, end;
        Flower(int x, int a) {
            this.start = x;
            this.end = a;
        }

        @Override
        public int compareTo(Flower flower) {
            if(this.start != flower.start) return this.start-flower.start;
            return this.end-flower.end;
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
        int n = Integer.parseInt(br.readLine());
        
        List<Flower> lst = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());
            lst.add(new Flower(100*startM+startD, 100*endM+endD));
        }

        Collections.sort(lst);

        Deque<Flower> q = new ArrayDeque<>();
        for(Flower f : lst) q.add(f);

        int endDate = 301, cnt = 0;
        
        while(!q.isEmpty()) {
            if(endDate >= 1201 || q.peekFirst().start > endDate) break;

            int tmpEndDate = -1;
            int sz = q.size();

            while(sz-- > 0) {
                if(q.peekFirst().start <= endDate) {
                    if(tmpEndDate <= q.peekFirst().end) {
                        tmpEndDate = q.peekFirst().end;
                    }
                    q.pollFirst();
                }
                else break;
            }

            endDate = tmpEndDate;
            cnt++;
        }

        bw.write((endDate >= 1201) ? cnt+"" : "0");
    }

}
