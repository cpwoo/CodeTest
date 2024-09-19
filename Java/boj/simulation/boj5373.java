package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;

public class boj5373 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final char[] color = {'w','r','y','g','b','o'};
    private static final int[] pIdx = {0,18,9,45,27,36};
    private static final int[] rIdx = {6,3,0,7,4,1,8,5,2};
    private static final int[][] p = 
    {{47,46,45,38,37,36,11,10,9,29,28,27},
    {15,16,17,42,43,44,51,52,53,33,34,35},
    {6,7,8,36,39,42,20,19,18,35,32,29},
    {2,1,0,27,30,33,24,25,26,44,41,38},
    {0,3,6,9,12,15,18,21,24,53,50,47},
    {8,5,2,45,48,51,26,23,20,17,14,11}};

    private static char cube[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int[] index = new int[26];
        index['U'-'A'] = 0;
        index['D'-'A'] = 1;
        index['F'-'A'] = 2;
        index['B'-'A'] = 3;
        index['L'-'A'] = 4;
        index['R'-'A'] = 5;

        cube = new char[54];

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            for(int i=0; i<54; i++) cube[i] = color[i/9];

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(n-- > 0) {
                String str = st.nextToken();
                int idx = index[str.charAt(0)-'A'];

                if(str.charAt(1) == '+') rotate(idx);
                else {
                    for(int i=0; i<3; i++) rotate(idx);
                }
            }

            for(int i=0; i<9; i++) {
                sb.append(cube[i]);
                if(i%3 == 2) sb.append('\n');
            }
        }

        bw.write(sb.toString());
    }

    private static void rotate(int idx) {
        char[] tmp = new char[12];
        
        for(int i=0; i<12; i++) tmp[(i+3)%12] = cube[p[idx][i]];
        for(int i=0; i<12; i++) cube[p[idx][i]] = tmp[i];
        
        for(int i=0; i<9; i++) tmp[i] = cube[rIdx[i]+pIdx[idx]];
        for(int i=0; i<9; i++) cube[pIdx[idx]+i] = tmp[i];
    }

}
