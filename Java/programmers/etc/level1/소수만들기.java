package CodeTest.Java.programmers.etc.level1;

public class 소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;

        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    if (isPrime(nums[i]+nums[j]+nums[k])) answer++;
                }
            }
        }

        return answer;
    }
    
    private Boolean isPrime(int num) {
        int cnt = 0;

        for (int i=2; i<=(int)Math.sqrt(num); i++) {
            if (num%i == 0) cnt++;
        }
        
        return cnt == 0;
    }
}
