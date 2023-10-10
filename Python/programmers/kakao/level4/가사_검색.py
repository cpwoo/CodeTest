def search(head, query):
    cur = head
    res = 0
    for char in query:
        if char == "?":
            return res
        else:
            if char not in cur[1]:
                return 0
            res = cur[1][char][0]
            cur = cur[1][char]
    return res


def solution(words, queries):
    answer = []
    prefix, suffix = {}, {}

    for word in words:
        wlen = len(word)
        if wlen not in prefix:
            prefix[wlen], suffix[wlen] = [0, {}], [0, {}]
        for dictionary, string in [prefix, word], [suffix, word[::-1]]:
            cur = dictionary[wlen]
            cur[0] += 1
            for char in string:
                if char not in cur[1]:
                    cur[1][char] = [0, {}]
                cur[1][char][0] += 1
                cur = cur[1][char]
    
    for query in queries:
        qlen = len(query)
        if qlen not in prefix:
            answer.append(0)
        elif query[0] == "?" and query[-1] == "?":
            answer.append(prefix[qlen][0])
        elif query[-1] == "?":
            answer.append(search(prefix[qlen], query))
        elif query[0] == "?":
            answer.append(search(suffix[qlen], query[::-1]))

    return answer


words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
queries = ["fro??", "????o", "fr???", "fro???", "pro?"]
print(solution(words, queries)) # [3, 2, 4, 1, 0]
