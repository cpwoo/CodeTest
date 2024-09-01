package CodeTest.Java.boj.impl;

import java.io.*;

public class boj2469 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        char[] start = new char[k];
        for(int i=0; i<k; i++) start[i] = (char)('A'+i);

        char[] target = br.readLine().toCharArray();

        String[] arr = new String[n];
        for(int i=0; i<n; i++) arr[i] = br.readLine();

        int idx = -1;
        for(int i=0; i<n; i++) {
            if(arr[i].charAt(0) == '?') {
                idx = i;
                break;
            }
        }

        for(int i=0; i<idx; i++) for(int j=0; j<k-1; j++) {
            if(arr[i].charAt(j) == '-') {
                char tmp = start[j];
                start[j] = start[j+1];
                start[j+1] = tmp;
            }
        }

        for(int i=n-1; i>idx; i--) for(int j=0; j<k-1; j++) {
            if(arr[i].charAt(j) == '-') {
                char tmp = target[j];
                target[j] = target[j+1];
                target[j+1] = tmp;
            }
        }

        sb = new StringBuilder();
        for(int i=0; i<k-1; i++) {
            if(start[i] == target[i]) sb.append('*');
            else {
                if(start[i] == target[i+1]) sb.append('-');
                else if(i > 0 && start[i] == target[i-1]) sb.append('*');
                else {
                    bw.write("x".repeat(k-1));
                    return;
                }
            }
        }

        bw.write(sb.toString());
    }

}
