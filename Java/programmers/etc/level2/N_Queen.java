package CodeTest.Java.programmers.etc.level2;

public class N_Queen {
    public int solution(int n) {
        int answer = 0;
        int[] cols = new int[n];
        answer = backtracking(0, cols, n);
        return answer;
    }

    private static int backtracking(int depth, int[] cols, int n) {
        if (depth == n) return 1;

        int total = 0;
        
        for (int i=0; i<n; i++) {
            cols[depth] = i;
            if (chk(depth, cols)) total += backtracking(depth+1, cols, n);
        }

        return total;
    }

    private static boolean chk(int depth, int[] cols) {
        for (int i=0; i<depth; i++) {
            if (cols[i] == cols[depth] || Math.abs(depth-i) == Math.abs(cols[depth]-cols[i])) return false;
        }
        return true;
    }
}
