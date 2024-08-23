package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj5419 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;
    
    private static long tree[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        List<int[]> nodes = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes.add(new int[]{x, y});
        }

        Collections.sort(nodes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int p = 0, q = nodes.get(0)[1];

        for(int[] node : nodes) {
            if(q == node[1]) node[1] = p;
            else {
                p++;
                q = node[1];
                node[1] = p;
            }
        }

        Collections.sort(nodes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0]-o2[0];
                return o2[1]-o1[1];
            }
        });

        int val = 131072;
        tree = new long[2*val];

        long ret = 0;
        for(int[] node : nodes) {
            ret += query(0, val-1, node[1], val-1, 1);
            update(val+node[1]);
        }

        sb.append(ret).append('\n');
    }

    private static long query(int start, int end, int left, int right, int idx) {
        if(left <= start && right >= end) return tree[idx];

        if(end < left || right < start) return 0;

        int mid = (start+end)/2;

        return query(start, mid, left, right, 2*idx)+query(mid+1, end, left, right, 2*idx+1);
    }

    private static void update(int idx) {
        tree[idx]++;
        idx >>= 1;
        while(idx != 0) {
            tree[idx] = tree[2*idx]+tree[2*idx+1];
            idx >>= 1;
        }
    }

}
