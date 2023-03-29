import math


def dfs(depth, c, mask):
    if depth == K:
        answer[0] = min(answer[0], c)
        return
    if c >= answer[0]:
        return
    for i in range(N):
        if not (mask & (1 << i)):
            continue
        for j in range(N):
            if mask & (1 << j):
                continue
            try:
                if d[mask | (1 << j)] > c + cost[i][j]:
                    d[mask | (1 << j)] = c + cost[i][j]
                    dfs(depth + 1, c + cost[i][j], mask | (1 << j))
            except:
                d[mask | (1 << j)] = c + cost[i][j]
                dfs(depth + 1, c + cost[i][j], mask | (1 << j))


if __name__ == "__main__":
    d = dict()
    answer = [math.inf]
    N = int(input())
    cost = []
    for i in range(N):
        cost.append(list(map(int, input().split())))
    status = str(input())
    K = int(input())
    s = 0
    count = 0
    for i in range(N):
        if status[i] == 'Y':
            s = s | (1 << i)
            K -= 1
    if K > 0:
        dfs(0, 0, s)
    else:
        answer[0] = 0
    if answer[0] != math.inf:
        print(answer[0])
    else:
        print(-1)