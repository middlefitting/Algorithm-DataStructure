def find(n):
    if p[n] < 0:
        return n
    p[n] = find(p[n])
    return find(p[n])


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    p[a] += p[b]
    p[b] = a


def find_loc(a, b):
    return a * M + b


if __name__ == "__main__":
    N, M, K = map(int, input().split())
    arr = [["."] * M for _ in range(N)]
    p = [-1] * N * M
    mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    for _ in range(K):
        x, y = map(int, input().split())
        arr[x - 1][y - 1] = "#"
    for x in range(N):
        for y in range(M):
            if arr[x][y] != "#":
                continue
            for mx, my in mv:
                tx = x + mx
                ty = y + my
                if 0 <= tx < N and 0 <= ty < M:
                    if arr[tx][ty] != "#":
                        continue
                    merge(find_loc(x, y), find_loc(tx, ty))
    print(min(p) * -1)



