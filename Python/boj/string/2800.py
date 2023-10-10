import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import combinations

string = [*input()] 
s, s_brs = [], []

for i,v in enumerate(string):
    if v == '(':
        string[i] = ''
        s += [i]
    if v == ')':
        string[i] = ''
        s_brs += [[s.pop(),i]]

out = set()
for i in range(len(s_brs)):
    for j in combinations(s_brs, i):
        S = string[:]
        for v,w in j:
            S[v] = '('
            S[w] = ')'
        out.add(''.join(S))

print(*sorted(out), sep='\n')
