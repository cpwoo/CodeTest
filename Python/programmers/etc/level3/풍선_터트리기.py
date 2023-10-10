def solution(a):
    def input_min(k):
        q = []
        t = k[0]
        for x in k:
            if t > x:
                t = x
            q.append(t)
        return q
    k = set(input_min(a) + input_min(a[::-1]))
    return len(k)


a = [9,-1,-5]
print(solution(a)) # 3

a = [-16,27,65,-2,58,-92,-71,-68,-61,-33]
print(solution(a)) # 6
