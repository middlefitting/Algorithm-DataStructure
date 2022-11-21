N = int(input())

arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))
answer = [0, 0]
v = [False] * (N * N)
maxNum = N * N
dx = [-1, -1, 1, 1]
dy = [-1, 1, -1, 1]


def posCheck(i, j):
    for d in range(4):
        x = i + dx[d]
        y = j + dy[d]
        while 0 <= x < N and 0 <= y < N:
            if v[x * N + y]:
                return False
            x += dx[d]
            y += dy[d]
    return True


def divNBishop(depth, temp, color):
    # if N * N - depth + 1 + temp <= answer[color] or temp >= N * N:
    #     return
    while depth < maxNum:
        i = depth // N
        j = depth % N
        if (arr[i][j]) and (posCheck(i, j)) and (not v[i * N + j]):
            v[depth] = True
            answer[color] = max(temp + 1, answer[color])
            divNBishop(depth + 2, temp + 1, color)
            v[depth] = False
        depth += 2


divNBishop(0, 0, 0)
divNBishop(1, 0, 1)
print(sum(answer))
