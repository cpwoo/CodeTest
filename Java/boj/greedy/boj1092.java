package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1092 {
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
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> crane = new PriorityQueue<>();

        int craneMax = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(st.nextToken());
            crane.add(x);
            craneMax = Math.max(craneMax, x);
        }

        int m = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> box = new PriorityQueue<>();

        int boxMax = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int x = Integer.parseInt(st.nextToken());
            box.add(x);
            boxMax = Math.max(boxMax, x);
        }
        
        if(craneMax < boxMax){
            bw.write("-1");
            return;
        }

        int ret = 0, cnt = 0;
        int sz = Math.max(ret, (int) Math.ceil(box.size()/crane.size()));

        while (!box.isEmpty()){
            if(crane.size() == 1){
                ret = Math.max(ret, box.size());
                break;
            }

            if(crane.peek() >= box.peek() && cnt < sz) {
                ret = Math.max(ret, ++cnt);
                box.poll();
                continue;
            }

            crane.poll();
            sz = Math.max(ret, (int) Math.ceil(box.size()/crane.size()));
            cnt = 0;
        }
        
        bw.write(ret+"");
    }

}
