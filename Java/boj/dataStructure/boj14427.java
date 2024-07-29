package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj14427 {
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
        int[] A = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        PriorityQueue<Node> q = new PriorityQueue<>();
        for(int i=1; i<n+1; i++) {
            q.add(new Node(A[i], i));
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if(x == 1) {
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                A[y] = z;
                q.add(new Node(z, y));
            } else {
                while(A[q.peek().idx] != q.peek().a) q.poll();
                bw.write(q.peek().idx+"\n");
            }
        }
    }

}

class Node implements Comparable<Node> {
    int a, idx;
    Node(int a, int idx) {
        this.a = a;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node node) {
        if(this.a != node.a) {
            return this.a-node.a;
        } else {
            return this.idx-node.idx;
        }
    }
}
