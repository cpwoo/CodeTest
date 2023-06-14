import sys
input = lambda: sys.stdin.readline().rstrip()

def chk(tmp):
    return abs(tmp) > int(1e9)

def solve(commands, n):
    s = [n]
    for cmd in commands:
        if cmd[:3] == "NUM":
            s.append(int(cmd[4:]))
        elif not s:
            return "ERROR"
        elif cmd == "POP":
            s.pop()
        elif cmd == "INV":
            s[-1] *= -1
        elif cmd == "DUP":
            s.append(s[-1])
        elif len(s) == 1:
            return "ERROR"
        elif cmd == "SWP":
            s[-1], s[-2] = s[-2], s[-1]
        elif cmd == "ADD":
            tmp = s.pop() + s.pop()
            if chk(tmp):
                return "ERROR"
            s.append(tmp)
        elif cmd == "SUB":
            tmp = -s.pop() + s.pop()
            if chk(tmp):
                return "ERROR"
            s.append(tmp)
        elif cmd == "MUL":
            tmp = s.pop() * s.pop()
            if chk(tmp):
                return "ERROR"
            s.append(tmp)
        elif cmd == "DIV":
            a, b = s.pop(), s.pop()
            if a == 0:
                return "ERROR"
            tmp = abs(b)//abs(a)
            if (a > 0 and b < 0) or (a < 0 and b > 0):
                tmp = -tmp
            if chk(tmp):
                return "ERROR"
            s.append(tmp)
        elif cmd == "MOD":
            a, b = s.pop(), s.pop()
            if a == 0:
                return "ERROR"
            tmp = abs(b)%abs(a)
            if b < 0:
                tmp = -tmp
            if chk(tmp):
                return "ERROR"
            s.append(tmp)
        else:
            return "ERROR"

    return s[0] if len(s) == 1 else "ERROR"


while True:
    commands = []
    while True:
        cmd = input()
        if cmd == "QUIT":
            exit()
        if cmd == "END":
            break
        commands.append(cmd)
    
    for _ in range(int(input())):
        print(solve(commands, int(input())))
    print()
    input()
