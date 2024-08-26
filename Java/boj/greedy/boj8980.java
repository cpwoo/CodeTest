package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj8980 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

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
        int c = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        int[][] box = new int[m][3];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) box[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(box, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return o1[1]-o2[1];
                else if(o1[0] != o2[0]) return o1[0]-o2[0];
                return o1[2]-o2[2];
            }
        });

        int ans = 0;
        int[] remain = new int[n+1];
        Arrays.fill(remain, c);

        for(int i=0; i<m; i++) {
            int tmp = c;
            
            for(int j=box[i][0]; j<box[i][1]; j++) tmp = Math.min(tmp, remain[j]);
            
            tmp = Math.min(tmp, box[i][2]);
            
            for(int j=box[i][0]; j<box[i][1]; j++) remain[j] -= tmp;
            
            ans += tmp;
        }

        bw.write(ans+"");
    }
}
