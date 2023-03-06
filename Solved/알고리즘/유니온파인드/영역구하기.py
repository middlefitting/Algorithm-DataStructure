def find(a):
    if uf[a] < 0:
        return a
    uf[a] = find(uf[a])
    return find(uf[a])


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    else:
        uf[a] += uf[b]
    uf[b] = a


if __name__ == "__main__":
    N, M, K = map(int, input().split())
    arr = [[0] * M for _ in range(N)]
    mv = [[1, 0], [0, 1], [-1, 0], [0, -1]]
    uf = [-1] * (N * M)
    answer = []
    for _ in range(K):
        y1, x1, y2, x2 = map(int, input().split())
        for i in range(N):
            for j in range(M):
                if x1 <= i < x2 and y1 <= j < y2:
                    arr[i][j] = 1
    for x in range(N):
        for y in range(M):
            if arr[x][y]:
                continue
            for mx, my in mv:
                tx, ty = x + mx, y + my
                if 0 <= tx < N and 0 <= ty < M:
                    if not arr[tx][ty]:
                        merge(x * M + y, tx * M + ty)
    for i in range(N):
        for j in range(M):
            if arr[i][j]:
                uf[i * M + j] = 0
    for i in uf:
        if i < 0:
            answer.append(i * -1)
    answer.sort()
    print(len(answer))
    for i in range(len(answer)):
        if i != len(answer) -1:
            print(answer[i], end=" ")
        else:
            print(answer[i])
