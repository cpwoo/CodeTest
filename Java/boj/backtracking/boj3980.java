package CodeTest.Java.boj.backtracking;

import java.io.*;

public class boj3980 {
    private static int _max;

    private static int[][] answer;
    private static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            answer = new int[11][11];
            for(int j=0; j<11; j++) {
                String[] inp = br.readLine().split(" ");
                for(int k=0; k<11; k++) {
                    answer[j][k] = Integer.parseInt(inp[k]);
                }
            }

            check = new boolean[11];

            _max = 0;
            getMax(0, 0);

            System.out.println(_max);
        }
    }

    private static void getMax(int idx, int total) {
        if(idx == 11) {
            _max = Math.max(_max, total);
            return;
        }

        for(int j=0; j<11; j++) {
            if(check[j]) continue;
            if(answer[idx][j] != 0) {
                check[j] = true;
                getMax(idx+1, total+answer[idx][j]);
                check[j] = false;
            }
        }
    }

}
