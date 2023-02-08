def solution(lottos, win_nums):
    rank = [6, 6, 5, 4, 3, 2, 1]
    disable = 0
    min_count = 0
    for i in lottos:
        if i == 0:
            disable += 1
        else:
            try:
                win_nums.index(i)
                min_count += 1
            except:
                continue
    max_count = min_count + disable
    return [rank[max_count], rank[min_count]]
