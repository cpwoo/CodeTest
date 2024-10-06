package CodeTest.Java.boj.simulation;

import java.io.*;
import java.util.*;
import java.util.Map.*;

public class boj17140 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int r, c, k;
    private static List<List<Integer>> data;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        data = new ArrayList<>();
        for(int i=0; i<3; i++) {
            List<Integer> tmp = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                tmp.add(Integer.parseInt(st.nextToken()));
            }
            data.add(tmp);
        }

        int time = 0;
        while(time < 101) {
            if(isK()) {
                bw.write(time+"");
                return;
            }
            time++;

            if(data.size() >= data.get(0).size()) updateData();
            else {
                data = transpose(data);
                updateData();
                data = transpose(data);
            }
        }

        bw.write("-1");
    }

    private static boolean isK() {
        if(r-1 < data.size() && c-1 < data.get(0).size()) {
            if(data.get(r-1).get(c-1) == k) return true;
        }
        return false;
    }

    private static void updateData() {
        List<List<Integer>> tmpMatrix = new ArrayList<>();
        int max = 0;

        for(List<Integer> row : data) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            for(int num : row) {
                if(num == 0) continue;
                cntMap.put(num, cntMap.getOrDefault(num, 0)+1);
            }

            List<int[]> cntList = new ArrayList<>();
            for(Entry<Integer, Integer> entry : cntMap.entrySet()) {
                cntList.add(new int[]{entry.getKey(), entry.getValue()});
            }

            cntList.sort((a, b) -> {
                if(a[1] != b[1]) return a[1]-b[1];
                return a[0]-b[0];
            });

            List<Integer> nRow = new ArrayList<>();
            for(int[] entry : cntList) {
                nRow.add(entry[0]);
                nRow.add(entry[1]);
            }

            max = Math.max(max, nRow.size());
            tmpMatrix.add(nRow);
        }

        for(List<Integer> row : tmpMatrix) {
            while(row.size() < max) row.add(0);
        }

        data = tmpMatrix;
    }

    private static List<List<Integer>> transpose(List<List<Integer>> matrix) {
        List<List<Integer>> transposed = new ArrayList<>();

        for(int i=0; i<matrix.get(0).size(); i++) {
            List<Integer> nRow = new ArrayList<>();
            for(int j=0; j<matrix.size(); j++) {
                nRow.add(matrix.get(j).get(i));
            }
            transposed.add(nRow);
        }

        return transposed;
    }

}
