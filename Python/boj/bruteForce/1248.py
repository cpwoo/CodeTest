import sys
input = lambda: sys.stdin.readline().rstrip()

def check(idx):
    hap = 0
    for i in range(idx, -1, -1):
        hap += result[i]
        if hap == 0 and s[i][idx] != 0:
            return False
        elif hap < 0 and s[i][idx] >= 0:
            return False
        elif hap > 0 and s[i][idx] <= 0:
            return False
    return True

def solve(idx):
    if idx == n:
        return True
    if s[idx][idx] == 0:
        result[idx] = 0
        return solve(idx+1)
    for i in range(1, 11):
        result[idx] = s[idx][idx] * i
        if check(idx) and solve(idx+1):
            return True
    return False


n = int(input())
arr = list(input())
s = [[0]*n for _ in range(n)]

for i in range(n):
    for j in range(i, n):
        tmp = arr.pop(0)
        if tmp == "+":
            s[i][j] = 1
        elif tmp == "-":
            s[i][j] = -1

result = [0]*n
solve(0)
print(*result)
