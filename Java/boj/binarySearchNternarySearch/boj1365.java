package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;
import java.util.*;

public class boj1365 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        String[] inp = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(0);
        for(int i=0; i<n; i++) {
            if(ts.last() > arr[i]) {
                ts.remove(ts.ceiling(arr[i]));
            }
            ts.add(arr[i]);
        }

        bw.write(n-ts.size()+1+"");

        bw.flush();
        bw.close();
    }
}
