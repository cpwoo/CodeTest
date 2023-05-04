from collections import deque

def solution(begin, target, words):
    def check(s1, s2):
        cnt = 0
        for i in range(len(s1)):
            if s1[i] != s2[i]:
                cnt += 1
        return cnt == 1
    
    visited = [0]*len(words)
    q = deque()
    q.append([begin, 0])
    while q:
        st, cnt = q.popleft()
        if st == target:
            return cnt
        for i in range(len(words)):
            if not visited[i] and check(st, words[i]):
                visited[i] = 1
                q.append([words[i], cnt+1])
    
    return 0


begin, target = "hit", "cog"
words = ["hot", "dot", "dog", "lot", "log", "cog"]
print(solution(begin, target, words)) # 4

begin, target = "hit", "cog"
words = ["hot", "dot", "dog", "lot", "log"]
print(solution(begin, target, words)) # 0
