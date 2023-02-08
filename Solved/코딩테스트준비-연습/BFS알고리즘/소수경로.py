import math
from collections import deque
MV = '0123456789'


def sosu(n):
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True


for _ in range(int(input())):
    N, M = map(str, input().split())
    v = [0] * 10000
    v[int(N)] = 1
    queue = deque([[N, 0]])
    answer = math.inf
    while queue:
        x, temp = queue.popleft()
        if x == M:
            answer = min(answer, temp)
        for mx in MV:
            for i in range(4):
                tx = int(x[:i] + mx + x[i + 1:])
                if tx < 1000:
                    continue
                if v[tx] != 0:
                    continue
                v[tx] = 1
                if not sosu(tx):
                    continue
                queue.append([str(tx), temp + 1])

    if answer == math.inf:
        print("Impossible")
    else:
        print(answer)
