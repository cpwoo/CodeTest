package CodeTest.Java.programmers.etc.level1;

public class 삼총사 {
    public int solution(int[] number) {
        int answer = 0;
        int n = number.length;
        
        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    if (number[i]+number[j]+number[k]==0) answer++;
                }
            }
        }
        
        return answer;
    }
}
