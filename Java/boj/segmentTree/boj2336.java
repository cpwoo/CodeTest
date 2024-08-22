package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj2336 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int max = 1000000;
    private static int tree[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[][] inp = new int[3][n];
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                inp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] student = new int[n+1][3];
        for(int i=0; i<n; i++) {
            student[inp[0][i]][0] = i+1;
            student[inp[1][i]][1] = i+1;
            student[inp[2][i]][2] = i+1;
        }
        
        Arrays.sort(student, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0]-o2[0];
                else if(o1[1] != o2[1]) return o1[1]-o2[1];
                return o1[2]-o2[2];
            }
        });

        tree = new int[4*n];
        for(int i=1; i<n+1; i++) update(i, max, 1, 1, n);
        
        int ret = 0;
        for(int i=1; i<n+1; i++) {
            if(query(1, student[i][1], 1, 1, n) > student[i][2]) ret++;
            update(student[i][1], student[i][2], 1, 1, n);
        }

        bw.write(ret+"");
    }

    private static int query(int left, int right, int node, int start, int end) {
        if(end < left || right < start) return max;

        if(left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        return Math.min(query(left, right, 2*node, start, mid), query(left, right, 2*node+1, mid+1, end));
    }

    private static int update(int pos, int val, int node, int start, int end) {
        if(end < pos || pos < start) return tree[node];

        if(start == end) return tree[node] = val;

        int mid = (start+end)/2;

        return tree[node] = Math.min(update(pos, val, 2*node, start, mid), update(pos, val, 2*node+1, mid+1, end));
    }

}
