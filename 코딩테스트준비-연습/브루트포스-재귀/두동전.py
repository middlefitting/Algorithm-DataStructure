import math
import sys

N, M = map(int, input().split())
arr = [list(str(input())) for _ in range(N)]
coinss = []
answer = [math.inf]
find = [False]
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]

for i in range(N):
    for j in range(M):
        if arr[i][j] == 'o':
            coinss.append([i, j])


def find_answer(coin):
    if coin[0] < 0 or coin[0] >= N:
        return 1
    if coin[1] < 0 or coin[1] >= M:
        return 1
    return 0


v = [[[[0] * M for _ in range(N)] for _ in range(M)] for _ in range(N)]


def dfs(depth, coins):
    if depth > 10:
        return
    if find_answer(coins[0]) + find_answer(coins[1]) == 1:
        find[0] = True
        answer[0] = min(depth, answer[0])
        return
    if find_answer(coins[0]) or find_answer(coins[1]):
        return
    for mx, my in mv:
        coin1 = [coins[0][0] + mx, coins[0][1] + my]
        coin2 = [coins[1][0] + mx, coins[1][1] + my]
        if 0 <= coin1[0] < N and 0 <= coin1[1] < M:
            if arr[coin1[0]][coin1[1]] == '#':
                coin1 = coins[0]
        if 0 <= coin2[0] < N and 0 <= coin2[1] < M:
            if arr[coin2[0]][coin2[1]] == '#':
                coin2 = coins[1]
        # if not find_answer(coin1) and not find_answer(coin2) and v[coin1[0]][coin1[1]][coin2[0]][coin2[1]] == 0:
        #     v[coin1[0]][coin1[1]][coin2[0]][coin2[1]] = 1
        #     dfs(depth + 1, [coin1, coin2])
        # if find_answer(coin1) or find_answer(coin2):
        #     dfs(depth + 1, [coin1, coin2])
        dfs(depth + 1, [coin1, coin2])


dfs(0, [coinss[0], coinss[1]])
if not find[0]:
    print(-1)
else:
    print(answer[0])
