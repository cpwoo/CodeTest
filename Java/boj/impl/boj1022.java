package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

// String 의 repeat 메소드는 Java 11부터 추가되므로 Java 11로 제출

public class boj1022 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r2-r1+1][c2-c1+1];
        int max = 0;
        for(int i=r1; i<r2+1; i++) for(int j=c1; j<c2+1; j++) {
            arr[i-r1][j-c1] = getValue(i, j);
            max = Math.max(max, arr[i-r1][j-c1]);
        }

        sb = new StringBuilder();

        for(int i=0; i<r2-r1+1; i++) {
            for(int j=0; j<c2-c1+1; j++) {
                int sub = String.valueOf(max).length()-String.valueOf(arr[i][j]).length();
                if(sub > 0) sb.append(" ".repeat(sub));
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

    private static int getValue(int x, int y) {
        int idx = Math.max(Math.abs(x), Math.abs(y));

        int beforeBase = (2*(idx-1)+1)*(2*(idx-1)+1);
        int base = (2*idx+1)*(2*idx+1);

        int dx = idx-x, dy = idx-y;

        return (x >= y) ? base-dx-dy : beforeBase+dx+dy;
    }

}
