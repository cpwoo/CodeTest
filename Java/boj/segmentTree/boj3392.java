package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj3392 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    
    private static int seg[], cnt[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        List<int[]> lst = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            lst.add(new int[]{x1, y1, y2-1, 1});
            lst.add(new int[]{x2, y1, y2-1, -1});
        }

        Collections.sort(lst, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i=0; i<3; i++) {
                    if(o1[i] != o2[i]) return o1[i]-o2[i];
                }
                return o1[3]-o2[3];
            }
        });

        seg = new int[30001*2*4];
        cnt = new int[30001*2*4];

        long ret = 0;
        update(1, 0, 30000, lst.get(0)[1], lst.get(0)[2], lst.get(0)[3]);

        for(int i=1; i<2*n; i++) {
            int dx = lst.get(i)[0]-lst.get(i-1)[0];
            ret += dx*seg[1];
            update(1, 0, 30000, lst.get(i)[1], lst.get(i)[2], lst.get(i)[3]);
        }

        bw.write(ret+"");
    }

    private static void update(int node, int start, int end, int left, int right, int val) {
        if(end < left || start > right) return;

        if(left <= start && end <= right) cnt[node] += val;
        else {
            int mid = (start+end)/2;
            update(2*node, start, mid, left, right, val);
            update(2*node+1, mid+1, end, left, right, val);
        }

        seg[node] = (cnt[node] > 0) ? end-start+1 : seg[2*node]+seg[2*node+1];
    }

}
