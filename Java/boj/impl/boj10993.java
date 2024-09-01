package CodeTest.Java.boj.impl;

import java.io.*;
import java.util.*;

// String 의 stripTrailing 메소드는 Java 11부터 추가되므로 Java 11로 제출

public class boj10993 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static char[][] stars;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int N = Integer.parseInt(br.readLine());
        
        int xSize = (1<<(N+1))-3, ySize = (1<<N)-1;
        
        stars = new char[ySize][xSize];
        for(int i=0; i<ySize; i++) Arrays.fill(stars[i], ' ');

        if(N%2 == 1) fillStars(0, ySize-1, N);
        else fillStars(0, 0, N);

        sb = new StringBuilder();
        for(int i=0; i<ySize; i++) {
            String line = new String(stars[i]);
            sb.append(line.stripTrailing()).append('\n');
        }

        bw.write(sb.toString());
    }

    private static void fillStars(int x, int y, int n) {
        if(n == 1) {
            stars[y][x] = '*';
            return;
        }

        int xSize = (1<<(n+1))-3, ySize = (1<<n)-1;

        if(n%2 == 1) {
            for(int i=0; i<xSize; i++) stars[y][x+i] = '*';
            
            for(int i=0; i<ySize; i++) stars[y-i][x+i] = '*';
            
            for(int i=0; i<ySize; i++) stars[y-i][x+xSize-i-1] = '*';

            fillStars(x+(1<<(n-1)), y+1-(1<<(n-1)), n-1);
        }
        else {
            for(int i=0; i<xSize; i++) stars[y][x+i] = '*';

            for(int i=0; i<ySize; i++) stars[y+i][x+i] = '*';

            for(int i=0; i<ySize; i++) stars[y+i][x+xSize-i-1] = '*';

            fillStars(x+(1<<(n-1)), y-1+(1<<(n-1)), n-1);
        }
    }

}
