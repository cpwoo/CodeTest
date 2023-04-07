def convert_notation(n, k):
    s = '0123456789ABCDEF'
    q, r = divmod(n, k)

    return convert_notation(q, k) + s[r] if q else s[r]

def solution(n, t, m, p):
    answer = ""
    st = ""
    for i in range(t*m):
        st += convert_notation(i, n)
    st = st[:t*m]
    for i in range(p-1, len(st), m):
        answer += st[i]
    return answer


n, t, m, p = 2, 4, 2, 1
print(solution(n, t, m, p)) # "0111"

n, t, m, p = 16, 16, 2, 1
print(solution(n, t, m, p)) # "02468ACE11111111"

n, t, m, p = 16, 16, 2, 2
print(solution(n, t, m, p)) # "13579BDF01234567"
