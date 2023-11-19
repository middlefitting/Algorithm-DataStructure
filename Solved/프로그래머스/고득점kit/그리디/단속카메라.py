def solution(routes):
    routes.sort(key = lambda x:x[1])
    temp = -1 * 30001
    answer = 0
    for s, e in routes:
        if s > temp:
            temp = e
            answer += 1
    return answer