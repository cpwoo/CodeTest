package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj3649 {
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
        while(br.ready()) {
            int x = Integer.parseInt(br.readLine())*10_000_000;
            int n = Integer.parseInt(br.readLine());
            
            int[] arr = new int[n];
            for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
            Arrays.sort(arr);

            int left = 0, right = n-1;
            boolean flag = false;

            while(left < right) {
                int tmp = arr[left]+arr[right];
                if(tmp == x) {
                    bw.write("yes "+arr[left]+" "+arr[right]+"\n");
                    flag = true;
                    break;
                }
                else if(tmp < x) left++;
                else right--;
            }
            if(!flag) bw.write("danger\n");
        }
    }

}
