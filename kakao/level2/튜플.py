def solution(st):
    answer = []
    st = st[2:-2]
    st = sorted(st.split("},{"), key=lambda s: len(s))
    visited = set()
    for s in st:
        elements = s.split(",")
        for e in elements:
            if e not in visited:
                visited.add(e)
                answer.append(int(e))
    return answer


s = "{{2},{2,1},{2,1,3},{2,1,3,4}}"
print(solution(s)) # [2, 1, 3, 4]

s = "{{1,2,3},{2,1},{1,2,4,3},{2}}"
print(solution(s)) # [2, 1, 3, 4]

s = "{{20,111},{111}}"
print(solution(s)) # [111, 20]

s = "{{123}}"
print(solution(s)) # [123]

s = "{{4,2,3},{3},{2,3,4,1},{2,3}}"
print(solution(s)) # [3, 2, 4, 1]
