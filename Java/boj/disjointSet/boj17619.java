package CodeTest.Java.boj.disjointSet;

import java.io.*;
import java.util.*;

public class boj17619 {
    static class Info implements Comparable<Info> {
        int start, end, idx;
        Info(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        @Override
        public int compareTo(Info info) {
            if(this.start != info.start) {
                return this.start - info.start;
            } else {
                return this.end - info.end;
            }
        }
    }

    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int p[];

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
        int Q = Integer.parseInt(st.nextToken());

        List<Info> arr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Info(a, b, i));
        }
        Collections.sort(arr);

        p = new int[N];
        for(int i=0; i<N; i++) p[i] = i;

        int curStart = arr.get(0).start, curEnd = arr.get(0).end, curIdx = arr.get(0).idx;
        for(int i=1; i<N; i++) {
            int nxtStart = arr.get(i).start, nxtEnd = arr.get(i).end, nxtIdx = arr.get(i).idx;
            if(curStart <= nxtStart && nxtStart <= curEnd) {
                union(curIdx, nxtIdx);
                if(curEnd <= nxtEnd) {
                    curStart = nxtStart; curEnd = nxtEnd; curIdx = nxtIdx;
                }
            } else {
                curStart = nxtStart; curEnd = nxtEnd; curIdx = nxtIdx;
            }
        }

        sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            sb.append((p[a] == p[b]) ? "1\n" : "0\n");
        }

        bw.write(sb.toString());
    }

    private static int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private static void union(int a, int b) {
        a = find(a); b = find(b);
        p[b] = a;
    }

}
