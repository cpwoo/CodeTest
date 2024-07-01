package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj9663 {
    private static int N, result;
    private static int[] row;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        row = new int[N];
        result = 0;

        dfs(0);

        bw.write(result + "");

        bw.flush();
        bw.close();
    }

    private static void dfs(int x) {
        if(x == N) {
            result++;
        } else {
            for(int i=0; i<N; i++) {
                row[x] = i;
                if(adjacent(x)) {
                    dfs(x+1);
                }
            }
        }
    }

    private static boolean adjacent(int x) {
        for(int i=0; i<x; i++) {
            if(row[x] == row[i] || Math.abs(row[x]-row[i]) == x-i) {
                return false;
            }
        }
        return true;
    }

}
