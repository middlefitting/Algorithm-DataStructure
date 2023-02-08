# 5 3 20
# 10 10 20 20 30
# 1 3
# 2 4
# 5 4
import sys

N, M, K = map(int, sys.stdin.readline().split())
cost = list(map(int, sys.stdin.readline().split()))
cost_arr = []
for i in range(N):
    cost_arr.append([i, cost[i]])
cost_arr.sort(key=lambda x: x[1])
uf = [-1] * N


def find(a):
    if uf[a] < 0:
        return a
    uf[a] = find(uf[a])
    return uf[a]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return True
    uf[b] = a
    return False


for i in range(M):
    a, b = map(int, sys.stdin.readline().split())
    merge(a - 1, b - 1)

answer = cost_arr[0][1]
if answer > K:
    print("Oh no")
    sys.exit()

for i in range(1, N):
    if not merge(cost_arr[i - 1][0], cost_arr[i][0]):
        answer += cost_arr[i][1]
    if answer > K:
        print("Oh no")
        sys.exit()

print(answer)
