def solution(players, callings):
    rank, player = dict(), dict()
    
    for idx, p in enumerate(players):
        rank[idx+1] = p
        player[p] = idx+1
        
    for cur_P in callings:
        cur_R = player[cur_P]
        prev_P = rank[cur_R-1]
        
        rank[cur_R-1], rank[cur_R] = rank[cur_R], rank[cur_R-1]
        player[prev_P], player[cur_P] = player[cur_P], player[prev_P]
        
    return list(rank.values())


players = ["mumu", "soe", "poe", "kai", "mine"]
callings = ["kai", "kai", "mine", "mine"]
print(solution(players, callings)) # ["mumu", "kai", "mine", "soe", "poe"]
