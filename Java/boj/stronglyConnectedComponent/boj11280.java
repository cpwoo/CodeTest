package CodeTest.Java.boj.stronglyConnectedComponent;

import java.io.*;
import java.util.*;

public class boj11280 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static List<Integer> graph[];
    private static Stack<Integer> stk;
    private static int n, visited[], idx, id, sccId[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[2*n];
        for(int i=0; i<2*n; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = convert(Integer.parseInt(st.nextToken()));
            int b = convert(Integer.parseInt(st.nextToken()));
            graph[a^1].add(b);
            graph[b^1].add(a);
        }

        stk = new Stack<>();
        visited = new int[2*n];
        Arrays.fill(visited, -1);
        idx = 0; id = 0;
        sccId = new int[2*n];
        Arrays.fill(sccId, -1);

        for(int i=1; i<2*n; i++) if(visited[i] == -1) scc(i);

        for(int i=0; i<2*n; i+=2) {
            if(sccId[i] == sccId[i+1]) {
                bw.write('0');
                return;
            }
        }
        bw.write('1');
    }

    private static int convert(int x) {
        return x > 0 ? (x-1)<<1 : (-x<<1)-1;
    }

    private static int scc(int cur) {
        int ret = visited[cur] = idx++;
        stk.add(cur);
        for(Integer nxt : graph[cur]) {
            if(visited[nxt] == -1) ret = Math.min(ret, scc(nxt));
            else if(sccId[nxt] == -1) ret = Math.min(ret, visited[nxt]);
        }
        int tmp;
        if (ret == visited[cur]) {
			do {
				sccId[tmp = stk.pop()] = id;
			} while (tmp != cur);
			id++;
		}
		return ret;
    }

}
