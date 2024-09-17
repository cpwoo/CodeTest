package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj22860 {
    static class Info {
        String name; boolean flag;

        Info(String name, boolean flag) {
            this.name = name;
            this.flag = flag;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static Map<String, List<Info>> map;
    private static Set<String> set;
    private static int fileCnt;

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
        int m = Integer.parseInt(st.nextToken());
        
        map = new HashMap<>();

        for(int i=0; i<n+m; i++) {
            st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            String f = st.nextToken();
            boolean c = (st.nextToken().charAt(0) == '1');

            if(!map.containsKey(p)) map.put(p, new ArrayList<>());

            List<Info> val = map.get(p);
            val.add(new Info(f, c));
            map.put(p, val);
        }

        int q = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(q-- > 0) {
            String[] query = br.readLine().split("/");
            set = new HashSet<>();
            fileCnt = 0;
            traverse(query[query.length-1]);
            sb.append(set.size()).append(' ').append(fileCnt).append('\n');
        }

        bw.write(sb.toString());
    }

    private static void traverse(String p) {
        if(!map.containsKey(p)) return;

        for(Info info : map.get(p)) {
            if(!info.flag) {
                if(!set.contains(info.name)) set.add(info.name);
                fileCnt++;
            }
            else traverse(info.name);
        }
    }

}
