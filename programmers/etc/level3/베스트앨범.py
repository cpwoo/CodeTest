from collections import defaultdict

def solution(genres, plays):
    answer = []
    d = defaultdict(list)
    for idx, (genre, play) in enumerate(zip(genres, plays)):
        d[genre].append([play , idx])
    genreSort = sorted(list(d.keys()), key=lambda x: sum(map(lambda y: y[0], d[x])), reverse=True)
    for g in genreSort:
        tmp = [e[1] for e in sorted(d[g], key=lambda x: (x[0], -x[1]), reverse=True)]
        answer += tmp[:min(len(tmp),2)]
    return answer


genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]
print(solution(genres, plays)) # [4, 1, 3, 0]
