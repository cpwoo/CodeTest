import java.util.Scanner;

public class SWEA1244 {
    static String[] arr;
    static int _max, num;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
        int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++) {
            arr = sc.next().split("");
            num = sc.nextInt();
            
            _max = 0;
            if (arr.length < num) num = arr.length;

            dfs(0, 0);
            System.out.println("#" + tc + " " + _max);
		}
	}
    
    private static void dfs(int start, int cnt) {
        if (cnt == num) {
            StringBuilder res = new StringBuilder();
            for (String a : arr) {
                res.append(a);
            }
            _max = Math.max(_max, Integer.parseInt(res.toString()));
            return;
        }
        
        for (int i=start; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                String tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                
                dfs(i, cnt+1);
                
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}
