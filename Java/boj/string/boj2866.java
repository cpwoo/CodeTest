package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj2866 {
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
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R][C];
        for(int i=0; i<R; i++) arr[i] = br.readLine().toCharArray();

        StringBuilder[] chk = new StringBuilder[C];
        for(int i=0; i<C; i++) {
            chk[i] = new StringBuilder();
            for(int j=0; j<R; j++) {
                chk[i].append(arr[j][i]);
            }
        }

        int cnt = 0;
        
        while(true) {
            Set<String> set = new HashSet<>();
            boolean flag = false;

            for(int i=0; i<C; i++) {
                chk[i].delete(0, 1);
                if(set.contains(chk[i].toString())) {
                    flag = true;
                    break;
                }
                else set.add(chk[i].toString());
            }
            if(flag) break;
            cnt++;
        }

        bw.write(cnt+"");
    }

}
