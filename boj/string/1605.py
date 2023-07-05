import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 100_003

def chk(mid):
    pos = [[] for _ in range(MOD)]
    h, power = 0, 1
    for i in range(0, L-mid+1):
        if i==0:
            for j in range(mid):
                h = (h+ord(s[mid-1-j])*power)%MOD
                if j < mid-1:
                    power = (power<<1)%MOD
        else:
            h = (2*(h-ord(s[i-1])*power) + ord(s[i+mid-1]))%MOD
        
        if pos[h]:
            for p in pos[h]:
                flag = True
                for j in range(mid):
                    if s[i+j] != s[p+j]:
                        flag = False
                        break
                if flag:
                    return True
        pos[h].append(i)
    
    return False


L = int(input())
s = input()

left, right = 0, L
while left+1 < right:
    mid = (left+right)//2
    if chk(mid):
        left = mid
    else:
        right = mid

print(left)
