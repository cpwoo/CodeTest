package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj3425 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static List<String> commands;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        while(true) {
            commands = new ArrayList<>();
            while(true) {
                String cmd = br.readLine();
                if(cmd.equals("QUIT")) return;
                if(cmd.equals("END")) break;
                commands.add(cmd);
            }

            int t = Integer.parseInt(br.readLine());
            for(int i=0; i<t; i++) {
                bw.write(go(Long.parseLong(br.readLine()))+"\n");
            }
            bw.write("\n");
            br.readLine();
        }
    }

    private static String go(long n) {
        Stack<Long> stack = new Stack<>();
        stack.add(n);
        for(String cmd: commands) {
            if(cmd.startsWith("NUM")) {
                stack.add(Long.parseLong(cmd.substring(4)));
            }
            else if(stack.isEmpty()) {
                return "ERROR";
            }
            else if(cmd.equals("POP")) {
                stack.pop();
            }
            else if(cmd.equals("INV")) {
                stack.add(-stack.pop());
            }
            else if(cmd.equals("DUP")) {
                stack.add(stack.peek());
            }
            else if(stack.size() == 1) {
                return "ERROR";
            }
            else if(cmd.equals("SWP")) {
                long a = stack.pop();
                long b = stack.pop();
                stack.add(a); stack.add(b);
            }
            else if(cmd.equals("ADD")) {
                long tmp = stack.pop() + stack.pop();
                if(chk(tmp)) return "ERROR";
                
                stack.add(tmp);
            }
            else if(cmd.equals("SUB")) {
                long tmp = -stack.pop() + stack.pop();
                if(chk(tmp)) return "ERROR";
                
                stack.add(tmp);
            }
            else if(cmd.equals("MUL")) {
                long tmp = stack.pop() * stack.pop();
                if(chk(tmp)) return "ERROR";
                
                stack.add(tmp);
            }
            else if(cmd.equals("DIV")) {
                long a = stack.pop();
                long b = stack.pop();
                if(a == 0) return "ERROR";
                long tmp = Math.abs(b)/Math.abs(a);
                if(a*b < 0) tmp *= -1;
                if(chk(tmp)) return "ERROR";
                stack.add(tmp);
            }
            else if(cmd.equals("MOD")) {
                long a = stack.pop();
                long b = stack.pop();
                if(a == 0) return "ERROR";
                long tmp = Math.abs(b)%Math.abs(a);
                if(b < 0) tmp *= -1;
                if(chk(tmp)) return "ERROR";
                stack.add(tmp);
            }
            else return "ERROR";
        }
        return (stack.size() == 1) ? stack.get(0)+"" : "ERROR";
    }

    private static boolean chk(long tmp) {
        return Math.abs(tmp) > 1000000000;
    }

}
