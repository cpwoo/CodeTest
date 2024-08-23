package CodeTest.Java.boj.segmentTree;

import java.io.*;
import java.util.*;

public class boj5676 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;
    
    private static int tree[], nodes[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        sb = new StringBuilder();
        while((line = br.readLine()) != null) {
            solve(line);
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve(String line) throws Exception {
        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        tree = new int[4*n];

        nodes = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) nodes[i] = Integer.parseInt(st.nextToken());

        init(0, n-1, 1);

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 'C') {
                nodes[b-1] = pmz(c);
                update(0, n-1, 1, b-1, pmz(c));
            }
            else {
                int res = query(0, n-1, 1, b-1, c-1);
                if(res == 0) sb.append('0');
                else if(res > 0) sb.append('+');
                else sb.append('-');
            }
        }

        sb.append('\n');
    }

    private static int pmz(int num) {
        if(num > 0) return 1;
        else if(num < 0) return -1;
        return 0;
    }

    private static int init(int start, int end, int idx) {
        if(start == end) {
            nodes[start] = pmz(nodes[start]);
            return tree[idx] = nodes[start];
        }

        int mid = (start+end)/2;

        return tree[idx] = init(start, mid, 2*idx)*init(mid+1, end, 2*idx+1);
    }

    private static void update(int start, int end, int idx, int changeIdx, int changeNum) {
        if(changeIdx < start || changeIdx > end) return;

        if(start == end) {
            tree[idx] = changeNum;
            return;
        }

        int mid = (start+end)/2;

        update(start, mid, 2*idx, changeIdx, changeNum);
        update(mid+1, end, 2*idx+1, changeIdx, changeNum);

        tree[idx] = tree[2*idx]*tree[2*idx+1];
    }

    private static int query(int start, int end, int idx, int left, int right) {
        if(left > end || right < start) return 1;

        if(left <= start && right >= end) return tree[idx];

        int mid = (start+end)/2;

        return query(start, mid, 2*idx, left, right)*query(mid+1, end, 2*idx+1, left, right);
    }

}
