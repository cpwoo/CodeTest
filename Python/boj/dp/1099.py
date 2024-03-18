import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

def change(a, b, w):
    cnt = 0
    for i in range(w):
        if a[i] != b[i]:
            cnt += 1
    return cnt


sentence = " "+input()
words = [input() for _ in range(int(input()))]

L = len(sentence)
dp = [[INF]*L for _ in range(L)]
dp[0][0] = 0

for i in range(1, L+1):
    if dp[0][i-1] == INF: continue
    
    for word in words:
        w = len(word)
        if sorted(sentence[i:i+w]) == sorted(word):
            dp[i][i+w-1] = min(dp[i][i+w-1], dp[0][i-1]+change(sentence[i:i+w], word, w))
            dp[0][i+w-1] = min(dp[0][i+w-1], dp[i][i+w-1])


print(dp[0][-1] if dp[0][-1] != INF else -1)
