package CodeTest.Java.programmers.kakao.level3;

public class 광고삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = calc(play_time);
        int adv = calc(adv_time);
        
        long[] time = new long[play+1];

        for (String log : logs) {
            String[] info = log.split("-");
            int start = calc(info[0]);
            int end = calc(info[1]);
            time[start]++;
            time[end]--;
        }

        for (int i=1; i<play+1; i++) {
            time[i] += time[i-1];
        }

        for (int i=1; i<play+1; i++) {
            time[i] += time[i-1];
        }

        long answer = 0;
        long _max = time[adv-1];
        for (int i=adv; i<play; i++) {
            long tmp = time[i]-time[i-adv];
            if (tmp > _max) {
                _max = tmp;
                answer = i-adv+1;
            }
        }

        long h = answer/3600;
        long m = (answer%3600)/60;
        long s = (answer%3600)%60;

        return String.format("%02d:%02d:%02d", h, m, s);
    }

    private static int calc(String time) {
        String[] tmp = time.split(":");
        int h = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int s = Integer.parseInt(tmp[2]);
        return h*3600 + m*60 + s;
    }
}
