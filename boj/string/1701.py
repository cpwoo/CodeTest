import sys
input = lambda: sys.stdin.readline().rstrip()

def make_table(pattern):
    table = [0]*len(pattern)
    j = 0
    for i in range(1, len(pattern)):
        while j > 0 and pattern[i] != pattern[j]:
            j = table[j-1]
        if pattern[i] == pattern[j]:
            j += 1
            table[i] = j
    return max(table)


s = input()
ans = 0
for i in range(len(s)):
    ans = max(ans, make_table(s[i:len(s)]))

print(ans)
