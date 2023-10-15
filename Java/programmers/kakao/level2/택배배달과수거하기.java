package CodeTest.Java.programmers.kakao.level2;

public class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int deliver = 0, pickup = 0;
        for (int i=n-1; i>=0; i--) {
            deliver += deliveries[i];
            pickup += pickups[i];
            
            while (deliver > 0 || pickup > 0) {
                deliver -= cap;
                pickup -= cap;
                answer += (i+1)*2;
            }
        }
        
        return answer;
    }
}
