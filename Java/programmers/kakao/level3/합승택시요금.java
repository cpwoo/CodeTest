package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] matrix = new int[n][n];
        for (int[] row : matrix) {
            Arrays.fill(row, 100_000_000);
        }

        for (int i=0; i<n; i++) {
            matrix[i][i] = 0;
        }

        for (int[] fare : fares) {
            matrix[fare[0]-1][fare[1]-1] = fare[2];
            matrix[fare[1]-1][fare[0]-1] = fare[2];
        }

        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (matrix[i][k]+matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k]+matrix[k][j];
                    }
                }
            }
        }

        int _min = Integer.MAX_VALUE;

        for (int k=0; k<n; k++) {
            _min = Math.min(_min, matrix[s-1][k]+matrix[k][a-1]+matrix[k][b-1]);
        }

        return _min;
    }
}
