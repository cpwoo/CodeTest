package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj12764 {
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
        List<Node> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Node(a, b));
        }

        Collections.sort(arr, (o1,o2)->o1.p-o2.p);

        int[] ret = new int[n];
        ret[0] = 1;

        PriorityQueue<Node> room = new PriorityQueue<>((o1,o2)->o1.p-o2.p);
        room.add(new Node(arr.get(0).q, 0));
        
        PriorityQueue<Integer> seat = new PriorityQueue<>();
        for(int i=1; i<n; i++) {
            seat.add(i);
        }
        
        for(int i=1; i<n; i++) {
            Node node = arr.get(i);
            int s = node.p, e = node.q;

            if(room.peek().p > s) {
                int pos = seat.poll();
                ret[pos]++;
                room.add(new Node(e, pos));
            } else {
                while(true) {
                    Node prev = room.poll();
                    int prevPos = prev.q;
                    if(!room.isEmpty() && room.peek().p <= s) {
                        seat.add(prevPos);
                    } else {
                        seat.add(prevPos);
                        int pos = seat.poll();
                        room.add(new Node(e, pos));
                        ret[pos]++;
                        break;
                    }
                }
            }
        }

        int idx = n;
        for(int i=0; i<n; i++) idx -= (ret[i] == 0) ? 1 : 0;

        bw.write(idx+"\n");
        for(int i=0; i<idx; i++) {
            bw.write(ret[i]+" ");
        }
    }

}

class Node {
    int p, q;
    Node(int p, int q) {
        this.p = p;
        this.q = q;
    }
}
