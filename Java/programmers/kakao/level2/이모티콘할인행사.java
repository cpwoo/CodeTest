package CodeTest.Java.programmers.kakao.level2;

public class 이모티콘할인행사 {
    int sign = 0, earn = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] arr = new int[emoticons.length];

        comb(arr, 0, users, emoticons);

        return new int[]{sign, earn};
    }

    private void comb(int[] arr, int idx, int[][] users, int[] emoticons) {
        if (idx == emoticons.length) {
            calculate(arr, users, emoticons);
            return;
        }

        for (int i=10; i<=40; i+=10) {
            arr[idx] = i;
            comb(arr, idx+1, users, emoticons);
        }
    }

    private void calculate(int[] arr, int[][] users, int[] emoticons) {
        int cnt = 0, earn_t = 0;

        for (int[] user : users) {
            int discount = user[0], price = user[1];
            int tot = 0;

            for (int i=0; i<arr.length; i++) {
                if (arr[i] >= discount) {
                    tot += (emoticons[i]/100)*(100-arr[i]);
                }
            }

            if (tot >= price) cnt++;
            else earn_t += tot;
        }

        if (cnt > sign) {
            sign = cnt;
            earn = earn_t;
            return;
        } else if (cnt == sign) {
            earn = Math.max(earn, earn_t);
        }
    }
}
