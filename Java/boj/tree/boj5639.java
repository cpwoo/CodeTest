package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj5639 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static List<Integer> arr;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        arr = new ArrayList<>();
        while(br.ready()) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        sb = new StringBuilder();

        postOrder(0, arr.size()-1);

        bw.write(sb.toString());
    }

    private static void postOrder(int first, int end) {
        if(first > end) return;

        int mid = end+1;

        for(int i=first+1; i<end+1; i++) {
            if(arr.get(first) < arr.get(i)) {
                mid = i;
                break;
            }
        }

        postOrder(first+1, mid-1);
        postOrder(mid, end);

        sb.append(arr.get(first)).append('\n');
    }

}
