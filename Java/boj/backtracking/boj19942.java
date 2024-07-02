package CodeTest.Java.boj.backtracking;

import java.io.*;
import java.util.*;

public class boj19942 {
    private static int n, mp, mf, ms, mv, cost;
    private static int[][] arr;
    private static boolean[] visited;
    private static TreeSet<String> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String[] inp = br.readLine().split(" ");
        mp = Integer.parseInt(inp[0]);
        mf = Integer.parseInt(inp[1]);
        ms = Integer.parseInt(inp[2]);
        mv = Integer.parseInt(inp[3]);

        arr = new int[n][5];
        for(int i=0; i<n; i++) {
            inp = br.readLine().split(" ");
            for(int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(inp[j]);
            }
        }

        visited = new boolean[n];
        cost = Integer.MAX_VALUE;
        answer = new TreeSet<>();
        dfs(0);

        if(!answer.isEmpty()) {
            bw.write(cost+"");
            bw.newLine();
            bw.write(answer.first());
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int idx) {
        if(idx == n) {
            calculate();
            return;
        }

        visited[idx] = true;
        dfs(idx+1);
        visited[idx] = false;
        dfs(idx+1);
    }

    private static void calculate() {
        int p = 0, f = 0, s = 0, v = 0, total = 0;

        for(int i=0; i<n; i++) {
            if(visited[i]) {
                p += arr[i][0];
                f += arr[i][1];
                s += arr[i][2];
                v += arr[i][3];
                total += arr[i][4];
            }
        }

        if (p >= mp && f >= mf && s >= ms && v >= mv) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++) {
                if (visited[i]) {
                    sb.append(i+1+" ");
                }
            }
            
            if(cost > total) {
                cost = total;
                answer = new TreeSet<>();
                answer.add(sb.toString());
            } else if(cost == total) {
                answer.add(sb.toString());
            }
        }
    }

}
