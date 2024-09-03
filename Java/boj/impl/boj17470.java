package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

public class boj17470 {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] table = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) table[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] four = {{0,1},{2,3}};

        boolean vert = false, hori = false;

        int rot = 0;

        int[] cmd = new int[r];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<r; i++) cmd[i] = Integer.parseInt(st.nextToken());

        for(int c : cmd) {
            switch(c) {
                case 1:
                    if(rot%2 == 1) hori = !hori;
                    else vert = !vert;
                    swap(four, 0, 0, 1, 0);
                    swap(four, 0, 1, 1, 1);
                    break;
                case 2:
                    if(rot%2 == 1) vert = !vert;
                    else hori = !hori;
                    swap(four, 0, 0, 0, 1);
                    swap(four, 1, 0, 1, 1);
                    break;
                case 3:
                    rot = (rot+1)%4;
                    rotate(four, 0, 0, 1, 0, 1, 1, 0, 1);
                    break;
                case 4:
                    rot = (rot+3)%4;
                    rotate(four, 0, 0, 0, 1, 1, 1, 1, 0);
                    break;
                case 5:
                    rotate(four, 0, 0, 1, 0, 1, 1, 0, 1);
                    break;
                case 6:
                    rotate(four, 0, 0, 0, 1, 1, 1, 1, 0);
                    break;
            }
        }

        int halfN = n/2, halfM = m/2;

        if(hori) {
            for(int x=0; x<n; x++) {
                rvRow(table[x], 0, halfM-1);
                rvRow(table[x], halfM, m-1);
            }
        }

        if(vert) {
            rvCol(table, 0, halfN-1);
            rvCol(table, halfN, n-1);
        }

        int[][][] quadTable = new int[4][halfN][halfM];

        for(int x=0; x<halfN; x++) for(int y=0; y<halfM; y++) {
            quadTable[0][x][y] = table[x][y];
            quadTable[1][x][y] = table[x][y+halfM];
            quadTable[2][x][y] = table[x+halfN][y];
            quadTable[3][x][y] = table[x+halfN][y+halfM];
        }

        int max = Math.max(halfN, halfM);

        int[][][] ret = new int[4][max][max];

        int tmp;

        switch(rot) {
            case 0:
                for(int x=0; x<halfN; x++) for(int y=0; y<halfM; y++) for(int k=0; k<4; k++) {
                    ret[k][x][y] = quadTable[k][x][y];
                }
                break;
            case 1:
                for(int x=0; x<halfN; x++) for(int y=0; y<halfM; y++) for(int k=0; k<4; k++) {
                    ret[k][y][halfN-1-x] = quadTable[k][x][y];
                }

                tmp = n;
                n = m;
                m = tmp;

                tmp = halfN;
                halfN = halfM;
                halfM = tmp;

                break;
            case 2:
                for(int x=0; x<halfN; x++) for(int y=0; y<halfM; y++) for(int k=0; k<4; k++) {
                    ret[k][halfN-1-x][halfM-1-y] = quadTable[k][x][y];
                }
                break;
            case 3:
                for(int x=0; x<halfN; x++) for(int y=0; y<halfM; y++) for(int k=0; k<4; k++) {
                    ret[k][halfM-1-y][x] = quadTable[k][x][y];
                }

                tmp = n;
                n = m;
                m = tmp;

                tmp = halfN;
                halfN = halfM;
                halfM = tmp;

                break;
        }

        sb = new StringBuilder();

        for(int x=0; x<halfN; x++) {
            for(int y=0; y<halfM; y++) sb.append(ret[four[0][0]][x][y]).append(' ');
            for(int y=0; y<halfM; y++) sb.append(ret[four[0][1]][x][y]).append(' ');
            sb.append('\n');
        }

        for(int x=0; x<halfN; x++) {
            for(int y=0; y<halfM; y++) sb.append(ret[four[1][0]][x][y]).append(' ');
            for(int y=0; y<halfM; y++) sb.append(ret[four[1][1]][x][y]).append(' ');
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

    private static void swap(int[][] arr, int r1, int c1, int r2, int c2) {
        int tmp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = tmp;
    }

    private static void rotate(int[][] arr, int r1, int c1, int r2, int c2, int r3, int c3, int r4, int c4) {
        int tmp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = arr[r3][c3];
        arr[r3][c3] = arr[r4][c4];
        arr[r4][c4] = tmp;
    }

    private static void rvRow(int[] row, int start, int end) {
        while(start < end) {
            int tmp = row[start];
            row[start] = row[end];
            row[end] = tmp;
            start++;
            end--;
        }
    }

    private static void rvCol(int[][] table, int start, int end) {
        while(start < end) {
            int[] tmp = table[start];
            table[start] = table[end];
            table[end] = tmp;
            start++;
            end--;
        }
    }

}
