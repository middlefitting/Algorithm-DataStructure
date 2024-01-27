# 4
# 24 21 14 10
#
import math

N = int(input())
arr = list(map(int, input().split()))
answer = math.inf


def dfs(idx, cnt):
    if idx >= 2 and arr[idx - 2] - arr[idx - 1] != arr[idx - 1] - arr[idx]:
        return
    if idx == (N - 1):
        global answer
        answer = min(answer, cnt)
        return
    dfs(idx + 1, cnt)
    for i in [1, -1]:
        arr[idx + 1] += i
        dfs(idx + 1, cnt + 1)
        arr[idx + 1] -= i


if __name__ == "__main__":
    dfs(-1, 0)
    if answer == math.inf:
        print(-1)
    else:
        print(answer)
