import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *
from collections import defaultdict

for _ in range(int(input())):
    minq, maxq = [], []
    total_ele_cnt = 0
    ele_cnt = defaultdict(int)
    
    for _ in range(int(input())):
        operator, number = input().split()
        if operator == 'I':
            number = int(number)
            heappush(maxq, -number)
            heappush(minq, number)
            ele_cnt[number] += 1
            total_ele_cnt += 1
        else:
            if total_ele_cnt > 0:
                if number == '1':
                    while 1:
                        del_num = -heappop(maxq)
                        if ele_cnt[del_num] != 0:
                            ele_cnt[del_num] -= 1
                            break
                else:
                    while 1:
                        del_num = heappop(minq)
                        if ele_cnt[del_num] != 0:
                            ele_cnt[del_num] -= 1
                            break
                total_ele_cnt -= 1
    
    if total_ele_cnt:
        while True:
            maxv = -heappop(maxq)
            if ele_cnt[maxv] != 0:
                break
        while True:
            minv = heappop(minq)
            if ele_cnt[minv] != 0:
                break
        print(maxv, minv)
    else:
        print('EMPTY')
