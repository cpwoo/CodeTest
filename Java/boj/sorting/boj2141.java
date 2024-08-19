package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj2141 {
    static class Info implements Comparable<Info> {
        int x, a;
        Info(int x, int a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Info info) {
            if(this.x != info.x) return this.x-info.x;
            return this.a-info.a;
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
        
        List<Info> lst = new ArrayList<>();
        long s = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            lst.add(new Info(x, a));
            s += a;
        }

        Collections.sort(lst);

        long cnt = 0;
        int pos = 0;

        for(int i=0; i<n; i++) {
            cnt += lst.get(i).a;
            if(cnt >= (s+1)/2) {
                pos = lst.get(i).x;
                break;
            }
        }

        bw.write(pos+"");
    }

}
