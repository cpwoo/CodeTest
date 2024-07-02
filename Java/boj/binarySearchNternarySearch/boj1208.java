package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;
import java.util.*;

public class boj1208 {
    private static int n, s, arr[];
    private static long answer;
    private static Map<Integer, Long> dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inp = br.readLine().split(" ");
        n = Integer.parseInt(inp[0]);
        s = Integer.parseInt(inp[1]);

        arr = new int[n];
        inp = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        dist = new HashMap<>();
        answer = 0;

        leftDFS(0, 0); rightDFS(n/2, 0);

        if(s == 0) answer--;
        bw.write(answer+"");

        bw.flush();
        bw.close();
    }

    private static void leftDFS(int idx, int cur) {
        if(idx == n/2) {
            dist.put(cur, dist.getOrDefault(cur, 0L)+1);
            return;
        }

        leftDFS(idx+1, cur);
        leftDFS(idx+1, cur+arr[idx]);
    }

    private static void rightDFS(int idx, int cur) {
        if(idx == n) {
            answer += dist.getOrDefault(s-cur, 0L);
            return;
        }

        rightDFS(idx+1, cur);
        rightDFS(idx+1, cur+arr[idx]);
    }

}
