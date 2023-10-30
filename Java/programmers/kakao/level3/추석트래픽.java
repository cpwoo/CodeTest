package CodeTest.Java.programmers.kakao.level3;

public class 추석트래픽 {
    public int solution(String[] lines) {
        int n = lines.length;
        int[] start_time = new int[n];
        int[] end_time = new int[n];
        
        for (int i=0; i<n; i++) {
            String line = lines[i].substring(11, lines[i].length()-1);
            String[] info = line.split(" ");
            int end = calc(info[0]);
            int duration = (int) (Double.parseDouble(info[1])*1000);
            int start = end-duration+1;
            start_time[i] = start;
            end_time[i] = end;
        }
        
        int answer = 0;
        for (int i=0; i<n; i++) {
            int cnt = 0;
            for (int j=i; j<n; j++) {
                if (end_time[i] > start_time[j]-1000) cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
    
    private static int calc(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        int s = Integer.parseInt(time.substring(6, 8));
        int ms = Integer.parseInt(time.substring(9));
        return (h*3600+m*60+s)*1000+ms;
    }
}
