package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj2162 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int parent[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[][] segments = new int[n][4];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                segments[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        for(int i=0; i<n; i++) for(int j=i+1; j<n; j++) {
            if(check(segments[i][0], segments[i][1], segments[i][2], segments[i][3], 
            segments[j][0], segments[j][1], segments[j][2], segments[j][3])) union(i, j);
        }

        for(int i=0; i<n; i++) parent[i] = find(parent[i]);

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int p : parent) {
            map.put(p, map.getOrDefault(p, 0)+1);
            max = Math.max(max, map.get(p));
        }

        bw.write(map.size()+"\n"+max+"");
    }

    private static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        a = find(a); b = find(b);
        parent[Math.max(a, b)] = Math.min(a, b);
    }

    private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Long.compare((x2-x1)*(y3-y1)-(y2-y1)*(x3-x1), 0);
    }

    private static boolean check(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int ccw1 = ccw(x1, y1, x2, y2, x3, y3);
        int ccw2 = ccw(x1, y1, x2, y2, x4, y4);
        int ccw3 = ccw(x3, y3, x4, y4, x1, y1);
        int ccw4 = ccw(x3, y3, x4, y4, x2, y2);

        if(ccw1*ccw2 == 0 && ccw3*ccw4 == 0) {
            if(Math.min(x1, x2) <= Math.max(x3, x4) && Math.max(x1, x2) >= Math.min(x3, x4)) {
                if(Math.min(y1, y2) <= Math.max(y3, y4) && Math.max(y1, y2) >= Math.min(y3, y4)) return true;
            }
        }
        
        else if(ccw1*ccw2 <= 0 && ccw3*ccw4 <= 0) return true;

        return false;
    }

}
