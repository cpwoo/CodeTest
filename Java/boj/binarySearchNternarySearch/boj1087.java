package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;
import java.util.*;

public class boj1087 {
    private static int N;
    private static int[][] X, Y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        X = new int[N][2];
        Y = new int[N][2];

        for(int i=0; i<N; i++) {
            String[] inp = br.readLine().split(" ");
            int sx = Integer.parseInt(inp[0]);
            int sy = Integer.parseInt(inp[1]);
            int dx = Integer.parseInt(inp[2]);
            int dy = Integer.parseInt(inp[3]);
            X[i][0] = sx; X[i][1] = dx;
            Y[i][0] = sy; Y[i][1] = dy;
        }

        double start = 0, end = 2000;
        for(int i=0; i<500; i++) {
            double left = (start*2+end)/3, right = (start+end*2)/3;
            if(solve(left) <= solve(right)) {
                end = right;
            } else {
                start = left;
            }
        }

        System.out.println(solve(start));
    }

    private static double solve(double t) {
        double[] posx = new double[N];
        double[] posy = new double[N];

        for(int i=0; i<N; i++) {
            posx[i] = X[i][0]+X[i][1]*t;
            posy[i] = Y[i][0]+Y[i][1]*t;
        }

        Arrays.sort(posx);
        Arrays.sort(posy);

        return Math.max(posx[N-1]-posx[0], posy[N-1]-posy[0]);
    }
    
}
