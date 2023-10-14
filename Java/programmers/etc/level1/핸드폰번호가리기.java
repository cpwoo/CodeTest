package CodeTest.Java.programmers.etc.level1;

public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        String answer = "";
        String[] nums = phone_number.split("");
        int n = nums.length;
        
        for (int i=0; i<n-4; i++) {
            answer += "*";
        }
        
        for (int i=4; i>0; i--) {
            answer += nums[n-i];
        }
        
        return answer;
    }
}
