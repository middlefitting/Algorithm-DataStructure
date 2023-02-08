from collections import deque

F, S, G, U, D = map(int, input().split())


def bfs(F, S, G, U, D):
    s = [0] * (F + 1)
    s[S] = 1
    heap = deque([S])
    if S == G:
        return 0

    while heap:
        x = heap.popleft()
        if x + U <= F:
            if not s[x + U]:
                s[x + U] = s[x] + 1
                heap.append(x + U)
                if x + U == G:
                    return s[x + U] - 1
        if x - D >= 1:
            if not s[x - D]:
                s[x - D] = s[x] + 1
                heap.append(x - D)
                if x - D == G:
                    return s[x - D] - 1
    return "use the stairs"


print(bfs(F, S, G, U, D))
