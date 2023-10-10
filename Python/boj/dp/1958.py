import sys
def input(): return sys.stdin.readline().rstrip()

seq_1, seq_2, seq_3 = input(), input(), input()
x, y, z = len(seq_1), len(seq_2), len(seq_3)

arr = [[[0]*(z+1) for _ in range(y+1)] for _ in range(x+1)]

for i in range(1, x+1):
    for j in range(1, y+1):
        for k in range(1, z+1):
            if seq_1[i-1] == seq_2[j-1] and seq_2[j-1] == seq_3[k-1]:
                arr[i][j][k] = arr[i-1][j-1][k-1] + 1
            else:
                arr[i][j][k] = max(arr[i-1][j][k], arr[i][j-1][k], arr[i][j][k-1])

ans = 0

for i in range(x+1):
    for j in range(y+1):
        ans = max(max(arr[i][j]), ans)

print(ans)
