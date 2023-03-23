import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import defaultdict

const = 100000
n = int(input())
dic1 = defaultdict(dict)
dic2 = defaultdict(dict)
dic3 = defaultdict(dict)
problem_dic = dict()
for _ in range(n):
    P, L, G = map(int,input().split())
    calc = L * const + P-1
    dic1[G][calc] = 1
    dic2[calc] = 1
    dic3[L][P] = 1
    problem_dic[P] = [L,G]
 
 
m = int(input())
for _ in range(m):
    c, *arg = input().split()
 
    if c == 'recommend':
        G, x = map(int,arg)
        if x > 0:
            calc = max(dic1[G].keys())
        else:
            calc = min(dic1[G].keys())
        L = calc // const
        P = calc % const + 1
        print(P)
    elif c == 'recommend2':
        x = int(arg[0])
        if x > 0:
            calc = max(dic2.keys())
        else:
            calc = min(dic2.keys())
        L = calc // const
        P = calc % const + 1
        print(P)
    elif c == 'recommend3':
        x, findL = map(int,arg)
        if x < 0:
            findL = findL + x
        result = -1
        while findL >= 0 and findL <= 100:
            if dic3.get(findL):
                if x > 0:
                    result = min(dic3[findL].keys())
                else:
                    result = max(dic3[findL].keys())
                break
            findL = findL + x
        print(result)
                
    elif c == 'solved':
        P = int(arg[0])
        L, G = problem_dic[P]
        calc = L * 100000 + P -1
        del dic3[L][P]
        del dic2[calc]
        del dic1[G][calc]
    else:
        P, L, G = map(int,arg)
        calc = L *100000 + P -1
        dic1[G][calc] = 1
        dic2[calc] = 1
        dic3[L][P] = 1
        problem_dic[P] = [L, G]
