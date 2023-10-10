import sys
input = lambda: sys.stdin.readline().rstrip()

def check(num):
    cnt = 0
    bin_num = bin(num)[2:]
    length = len(bin_num)

    for i in range(length):
        if bin_num[i] == "1":
            pow = length - (i+1)
            cnt += psum[pow]
            cnt += (num - 2**pow + 1)
            num = num - 2**pow
    return cnt


a, b = map(int, input().split())
psum = [0]*60

for i in range(1, 60):
    psum[i] = 2**(i-1) + 2*psum[i-1]

print(check(b)-check(a-1))
