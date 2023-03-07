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
    uf[a] += uf[b]
    uf[b] = a


def init(h):
    for i in range(N):
        for j in range(N):
            if arr[i][j] <= h:
                uf[i * N + j] = 0
                temp[i][j] = 1


def union_find():
    for x in range(N):
        for y in range(N):
            if temp[x][y]:
                continue
            for mx, my in mv:
                tx, ty = x + mx, y + my
                if (not 0 <= tx < N) or (not 0 <= ty < N):
                    continue
                if temp[tx][ty]:
                    continue
                merge(x * N + y, tx * N + ty)


def find_temp_answer():
    result = 0
    for i in uf:
        if i < 0:
            result += 1
    return result


if __name__ == "__main__":
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    answer = 0
    mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    for h in range(101):
        uf = [-1] * (N ** 2)
        temp = [[0] * N for _ in range(N)]
        init(h)
        union_find()
        answer = max(answer, find_temp_answer())
    print(answer)

