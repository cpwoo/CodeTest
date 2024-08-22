package CodeTest.Java.boj.string;

import java.io.*;

public class boj17609 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            String word = br.readLine();
            int left = 0, right = word.length()-1;
            sb.append(check1(word, left, right));
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static String check1(String word, int left, int right) {
        while(left < right) {
            if(word.charAt(left) == word.charAt(right)) {
                left++; right--;
            }
            else {
                return (check0(word, left+1, right) || check0(word, left, right-1)) ? "1\n" : "2\n";
            }
        }
        return "0\n";
    }

    private static boolean check0(String word, int left, int right) {
        while(left < right) {
            if(word.charAt(left) == word.charAt(right)) {
                left++; right--;
            }
            else return false;
        }
        return true;
    }

}
