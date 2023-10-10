def solution(words):
    answer = 0
    trie = {}
    
    for word in words:
        cur_trie = trie
        for w in word:
            cur_trie.setdefault(w, [0, {}])
            cur_trie[w][0] += 1
            cur_trie = cur_trie[w][1]
    
    for word in words:
        cur_trie = trie
        for i, w in enumerate(word):
            if cur_trie[w][0] == 1:
                break
            cur_trie = cur_trie[w][1]
        answer += i+1

    return answer


words = ["go","gone","guild"]
print(solution(words)) # 7

words = ["abc","def","ghi","jklm"]
print(solution(words)) # 4

words = ["word","war","warrior","world"]
print(solution(words)) # 15
