package CodeTest.Java.boj.greedy;

import java.io.*;

public class boj2138 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n], arr2 = new int[n], ans = new int[n];
        int cnt1 = 0, cnt2 = 0;

        String inp = br.readLine();
        for(int i=0; i<n; i++) {
            arr1[i] = inp.charAt(i)-'0';
            arr2[i] = inp.charAt(i)-'0';
        }

        inp = br.readLine();
        for(int i=0; i<n; i++) ans[i] = inp.charAt(i)-'0';

        arr1[0] = 1-arr1[0];
        arr1[1] = 1-arr1[1];
        cnt1++;

        for(int i=0; i<n-1; i++) {
            if(arr1[i] != ans[i]) {
                arr1[i] = 1-arr1[i];
                arr1[i+1] = 1-arr1[i+1];
                if(i+2 < n) arr1[i+2] = 1-arr1[i+2];
                cnt1++;
            }
            if(arr2[i] != ans[i]) {
                arr2[i] = 1-arr2[i];
                arr2[i+1] = 1-arr2[i+1];
                if(i+2 < n) arr2[i+2] = 1-arr2[i+2];
                cnt2++;
            }
        }

        if(arr1[n-1] != ans[n-1] && arr2[n-1] != ans[n-1]) {
            bw.write("-1");
            return;
        }

        if(arr1[n-1] != ans[n-1]) {
            bw.write(cnt2+"");
            return;
        }

        if(arr2[n-1] != ans[n-1]) {
            bw.write(cnt1+"");
            return;
        }
        
        bw.write(Math.min(cnt1, cnt2)+"");
    }

}
