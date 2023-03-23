import sys
input = lambda: sys.stdin.readline().rstrip()

import re
from functools import cmp_to_key

def comp(first, second):
    for i in range(min(len(first[1]), len(second[1]))):
        if first[1][i].isdigit() and second[1][i].isalpha(): return -1
        
        elif first[1][i].isalpha() and second[1][i].isdigit(): return 1
        
        elif first[1][i].isdigit() and second[1][i].isdigit():
            if int(first[1][i]) == int(second[1][i]):
                if len(first[1][i]) == len(second[1][i]):
                    continue
                return len(first[1][i]) - len(second[1][i])
            else:
                return int(first[1][i]) - int(second[1][i])
        
        else:
            if first[1][i] == second[1][i]:
                continue
            else:
                return alphabet.index(first[1][i]) - alphabet.index(second[1][i])
    
    return len(first[1]) - len(second[1])


data = []
for _ in range(int(input())):
    d = input()
    tmp = re.findall('[a-zA-Z]|\d+', d)
    data.append([d, tmp])
    
alphabet = 'AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz'

answer = sorted(data, key=cmp_to_key(comp))
for i in answer:
    print(i[0])
