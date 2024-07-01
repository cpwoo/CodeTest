package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj15661 {
    private static int n, answer, t;
    private static int[][] map;
    private static boolean[] v;

    private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        v = new boolean[n];

        answer = Integer.MAX_VALUE;
        t = 0;

        for(int i=0; i<n; i++) {
            String[] inp = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(inp[j]);
            }
        }

        for(t=1; t<n; t++) {
            nCr(0, 0);
        }
        
        bw.write(answer + "");

        bw.flush();
        bw.close();
    }

    private static void nCr(int depth, int start) throws Exception {
        if(depth == t) {
            answer = Math.min(answer, diff());
            if(answer == 0) {
                bw.write(answer + "");
                bw.flush();
                bw.close();
                System.exit(0);
            }
            return;
        }
        
        for(int i=start; i<n; i++) {
            if(!v[i]) {
                v[i] = true;
                nCr(depth+1, i+1);
                v[i] = false;
            }
        }
    }

    private static int diff() {
        int start = 0, link = 0;
        
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(v[i] && v[j]) {
                    start += map[i][j]+map[j][i];
                } else if (!v[i] && !v[j]) {
                    link += map[i][j]+map[j][i];
                }
            }
        }

        return Math.abs(start-link);
    }
   
}
