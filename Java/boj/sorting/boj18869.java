package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj18869 {
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
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++) {
            int[] tmp = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) tmp[j] = Integer.parseInt(st.nextToken());
            
            int[] sortedTmp = Arrays.copyOf(tmp, n);
            Arrays.sort(sortedTmp);

            Map<Integer, Integer> map = new HashMap<>();
            for(int j=0; j<n; j++) {
                map.put(sortedTmp[j], j);
            }

            for(int j=0; j<n; j++) {
                arr[i][j] = map.get(tmp[j]);
            }
        }

        int cnt = 0;
        for(int i=0; i<m-1; i++) for(int j=i+1; j<m; j++) {
            boolean flag = true;
            for(int k=0; k<n; k++) {
                if(arr[i][k] != arr[j][k]) {
                    flag = false;
                    break;
                }
            }
            cnt = (flag) ? cnt+1 : cnt;
        }

        bw.write(cnt+"");
    }

}
