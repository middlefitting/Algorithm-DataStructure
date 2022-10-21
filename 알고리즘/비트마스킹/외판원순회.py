import sys

N = int(sys.stdin.readline())
arr = []
INF = float('inf')
# None 여부를 비교하는 것이 속도 향상에 있어 중요하다..
dp = [[None] * (1 << N) for _ in range(N)]
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))


def TSP(current, visited):
    ret = dp[current][visited]
    if ret is not None:
        return ret

    if visited == (1 << N) - 1:
        if arr[current][0]:
            return arr[current][0]
        return INF

    ret = INF
    for i in range(N):
        if (visited & (1 << i)) or (not arr[current][i]):
            continue
        ret = min(ret, TSP(i, visited | (1 << i)) + arr[current][i])
    dp[current][visited] = ret
    return ret


print(TSP(0, 1))
