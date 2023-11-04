package CodeTest.Java.programmers.etc.level3;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        for (int i=1; i<n; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j=1; j<i; j++) 
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }
        
        int answer = 0;
        for (int j=0; j<triangle[n-1].length; j++) {
            answer = Math.max(answer, triangle[n-1][j]);
        }
        return answer;
    }
}
