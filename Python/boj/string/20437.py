import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import defaultdict

def string_game(d):
    min_str, max_str = 10000, 0
    for i in d:
        for j in range(len(d[i])-k+1):
            length = d[i][j+k-1] - d[i][j] + 1
            min_str = min(min_str, length)
            max_str = max(max_str, length)
    return (min_str, max_str)

for _ in range(int(input())):
    word, k = input(), int(input())
    d = defaultdict(list)
    for i in range(len(word)):
        if word.count(word[i]) >= k:
            d[word[i]].append(i)
    if not d:
        print(-1)
    else:
        print(*string_game(d))
