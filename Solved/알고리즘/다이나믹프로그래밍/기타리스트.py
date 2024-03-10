# 3 5 10
# 5 3 7

N, S, M = map(int, input().split())
V = list(map(int, input().split()))
v_set = set()
v_set.add(S)


def dfs(s, depth):
    if depth == N:
        if not s:
            print(-1)
        else:
            print(max(s))
        return
    temp = V[depth]
    next_s = set()
    for i in s:
        if (i - temp) >= 0:
            next_s.add(i - temp)
        if (i + temp) <= M:
            next_s.add(i + temp)
    dfs(next_s, depth + 1)


dfs(v_set, 0)



