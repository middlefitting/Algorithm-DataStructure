import math
from collections import deque


def print_result():
    result = math.inf
    for i in answer:
        result = min(min(i), result)
    print(result)


def set_answer(temp_arr):
    for i in range(N + 2):
        for j in range(M + 2):
            answer[i][j] += temp_arr[i][j]


def bfs(s):
    mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    v = [[math.inf] * (M + 2) for _ in range(N + 2)]
    v[s[0]][s[1]] = 0
    queue = deque([s])
    while queue:
        x, y = queue.popleft()
        w = v[x][y]
        for mx, my in mv:
            tx, ty = x + mx, y + my
            tw = w
            if (not 0 <= tx < N + 2) or (not 0 <= ty < M + 2):
                continue
            if m[tx][ty] == "*":
                continue
            if m[tx][ty] == "#":
                tw += 1
            if v[tx][ty] > tw:
                v[tx][ty] = tw
                queue.append([tx, ty])
    return v


def init():
    for i in range(N):
        for j in range(M):
            if arr[i][j] == "$":
                start.append([i + 1, j + 1])
            if arr[i][j] == "#":
                answer[i + 1][j + 1] -= 2
            m[i + 1][j + 1] = arr[i][j]


if __name__ == "__main__":
    for __ in range(int(input())):
        N, M = map(int, input().split())
        m = [["."] * (M + 2) for _ in range(N + 2)]
        answer = [[0] * (M + 2) for _ in range(N + 2)]
        arr = [list(str(input())) for _ in range(N)]
        start = [[0, 0]]
        init()
        for s in start:
            set_answer(bfs(s))
        print_result()

