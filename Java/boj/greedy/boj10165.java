package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj10165 {
    static class Info implements Comparable<Info> {
        int s, e, i;
        Info(int s, int e, int i) {
            this.s = s;
            this.e = e;
            this.i = i;
        }

        @Override
        public int compareTo(Info info) {
            if(this.s != info.s) return this.s-info.s;
            else if(this.e != info.e) return info.e-this.e;
            return this.i-info.i;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Info> infos = new ArrayList<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a < b) {
                infos.add(new Info(a, b, i));
                infos.add(new Info(a+n, b+n, i));
            }
            else infos.add(new Info(a, b+n, i));
        }

        Collections.sort(infos);

        boolean[] visited = new boolean[m];

        int left = 0, right = 0;
        for(int i=0; i<infos.size(); i++) {
            Info info = infos.get(i);
            if(visited[info.i]) continue;
            if(left <= info.s && info.e <= right) {
                visited[info.i] = true;
                continue;
            }
            left = info.s; right = info.e;
        }

        sb = new StringBuilder();
        for(int i=0; i<m; i++) if(!visited[i]) sb.append(i+1).append(' ');

        bw.write(sb.toString());
    }
}
