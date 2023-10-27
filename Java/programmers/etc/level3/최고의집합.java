package CodeTest.Java.programmers.etc.level3;

public class 최고의집합 {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        
        int d = s/n, m = s%n;
        
        int[] answer = new int[n];
        for (int i=0; i<n-m; i++) answer[i] = d;
        for (int i=n-m; i<n; i++) answer[i] = d+1;
        
        return answer;
    }
}
