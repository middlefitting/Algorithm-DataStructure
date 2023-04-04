from collections import deque

if __name__ == "__main__":
    N, M, K = map(int, input().split())
    d = dict()
    vec = [[] for _ in range(N + 1)]
    v = [[0] * ((1 << 14) + 1) for _ in range(N + 1)]
    queue = deque([[1, 0, 0]])
    answer = 0

    for i in range(1, N + 1):
        d[i] = -1
    for i in range(K):
        d[int(input())] = i

    for i in range(M):
        a, b, c = map(int, input().split())
        vec[a].append([b, c])
        vec[b].append([a, c])

    while queue:
        x, temp, mask = queue.popleft()
        if x == 1:
            answer = max(answer, temp)
        for y, tc in vec[x]:
            if (not v[y][mask]) and (tc >= temp):
                v[y][mask] = 1
                queue.append([y, temp, mask])
            if (d[y] >= 0) and (mask | (1 << d[y])) != mask and (not v[y][mask | (1 << d[y])]) and (tc >= temp):
                v[y][mask | (1 << d[y])] = 1
                queue.append([y, temp + 1, mask | (1 << d[y])])
    print(answer)

