package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj21939 {
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
        PriorityQueue<Node> minq = new PriorityQueue<>();
        PriorityQueue<Node> maxq = new PriorityQueue<>(Collections.reverseOrder());
        
        int[] level = new int[100001];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            minq.add(new Node(l, p));
            maxq.add(new Node(l, p));
            level[p] = l;
        }

        int m = Integer.parseInt(br.readLine());
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            if(c.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                minq.add(new Node(l, p));
                maxq.add(new Node(l, p));
                level[p] = l;
            } else if(c.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                level[p] = 0;
            } else if(c.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    while(!maxq.isEmpty() && level[maxq.peek().P] != maxq.peek().L) {
                        maxq.poll();
                    }
                    bw.write(maxq.peek().P+"\n");
                } else if(x == -1) {
                    while(!minq.isEmpty() && level[minq.peek().P] != minq.peek().L) {
                        minq.poll();
                    }
                    bw.write(minq.peek().P+"\n");
                }
            }
        }
    }

}

class Node implements Comparable<Node> {
    int L, P;
    Node(int L, int P) {
        this.L = L;
        this.P = P;
    }

    @Override
    public int compareTo(Node node) {
        if(this.L != node.L) {
            return this.L-node.L;
        } else {
            return this.P-node.P;
        }
    }
}
