package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj1655 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>((o1,o2)->o2-o1);

        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(leftHeap.size() == rightHeap.size()) {
                rightHeap.add(x);

                if(!leftHeap.isEmpty() && leftHeap.peek() < rightHeap.peek()) {
                    leftHeap.add(rightHeap.poll());
                    rightHeap.add(leftHeap.poll());
                }
            } else {
                leftHeap.add(x);

                if(rightHeap.peek() > leftHeap.peek()) {
                    leftHeap.add(rightHeap.poll());
                    rightHeap.add(leftHeap.poll());
                }
            }
            bw.write(rightHeap.peek()+"\n");
        }
    }

}
