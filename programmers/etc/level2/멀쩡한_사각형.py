def gcd(a,b):
    while b:
        a, b = b, a%b
    return a

def solution(w,h):
    tot = w*h
    g = gcd(w,h)
    w, h = w//g, h//g
    cut = w+h-1
    return tot - g*cut


w,h = 8,12
print(solution(w,h)) # 80
