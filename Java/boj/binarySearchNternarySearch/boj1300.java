package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;

public class boj1300 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 0, end = k;
        int answer = 0;

        int mid, cnt;
        while(start <= end) {
            mid = (start+end)/2;
            cnt = 0;
            for(int i=1; i<n+1; i++) {
                cnt += Math.min(mid/i, n);
            }
            if(cnt < k) {
                start = mid+1;
            } else {
                answer = mid;
                end = mid-1;
            }
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();
    }
}
