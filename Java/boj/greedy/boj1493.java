package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1493 {
    static class Cube implements Comparable<Cube> {
        int w, cnt;
        Cube(int a, int b) {
            this.w = a;
            this.cnt = b;
        }

        @Override
        public int compareTo(Cube cube) {
            if(this.w != cube.w) return cube.w-this.w;
            return cube.cnt-this.cnt;
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
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        List<Cube> cubes = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cubes.add(new Cube(a, b));
        }

        Collections.sort(cubes);

        long ret = 0, cur = 0;
        for(Cube cube : cubes) {
            cur *= 8;
            long v = 1<<cube.w;
            long max = (L/v)*(W/v)*(H/v)-cur;
            max = Math.min(cube.cnt, max);
            ret += max;
            cur += max;
        }

        bw.write((cur == (long) L*W*H) ? ret+"" : "-1");
    }

}
