import sys
input = lambda: sys.stdin.readline().rstrip()

def calc(a, op, b):
    if op == "+":
        return (a+int(b))%7
    elif op == "*":
        return (a*int(b))%7

for _ in range(int(input())):
    mod = set()
    mod.add(1)
    for _ in range(int(input())):
        tmp = set()
        op1, v1, op2, v2 = input().split()
        for m in mod:
            tmp.add(calc(m, op1, v1))
            tmp.add(calc(m, op2, v2))
        mod = tmp

    print("LUCKY" if 0 in mod else "UNLUCKY")
