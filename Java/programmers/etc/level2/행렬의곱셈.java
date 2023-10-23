package CodeTest.Java.programmers.etc.level2;

public class 행렬의곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length, m = arr1[0].length, r = arr2[0].length;

        int[][] answer = new int[n][r];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=0; k<r; k++) {
                    answer[i][k] += arr1[i][j]*arr2[j][k];
                }
            }
        }

        return answer;
    }
}
