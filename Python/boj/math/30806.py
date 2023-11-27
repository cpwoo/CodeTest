import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 998244353

class Comb:
    def __init__(self, sz):
        self.fact = [1]*(sz+1)
        self.factInv = [1]*(sz+1)
        
        for i in range(1, sz+1):
            self.fact[i] = (self.fact[i-1]*i)%MOD
        
        self.factInv[sz] = pow(self.fact[sz], -1, MOD)
        for i in range(sz-1, -1, -1):
            self.factInv[i] = (self.factInv[i+1]*(i+1))%MOD
        
        assert self.factInv[0] == 1
    
    def C(self, n, k):
        return ((self.fact[n] * self.factInv[k]) % MOD * self.factInv[n-k]) % MOD
    
def main():
    n = int(input())
    arr = []
    for _ in range(n):
        arr.extend(list(map(int, input().split()))[1:])
    arr.sort()

    coeff = [0]*(n+1)

    cnt, last = 0, -1
    for a in arr:
        if a != last:
            if cnt > 0:
                coeff[cnt] += 1
            cnt, last = 0, a
        cnt += 1
    coeff[cnt] += 1

    comb = Comb(1000000)

    res = [0]*(n+1)
    for i in range(n+1):
        if coeff[i]:
            for j in range(i+1):
                res[j] = (res[j]+coeff[i]*comb.C(i,j))%MOD
    
    print(*res[1:], sep='\n')

if __name__ == "__main__":
    main()
