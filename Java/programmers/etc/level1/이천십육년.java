package CodeTest.Java.programmers.etc.level1;

public class 이천십육년 {
    public String solution(int a, int b) {
        int answer = 0;
        String[] days = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] months = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        for (int i=0; i<a-1; i++) {
            answer += months[i];
        }
        
        answer = (answer+b-1)%7;
        
        return days[answer];
    }
}
