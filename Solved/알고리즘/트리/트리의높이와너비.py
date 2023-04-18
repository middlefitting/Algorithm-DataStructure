import math


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
    uf[b] = a


def dfs(tree_info, node, depth, p):
    if vec[node][0] != -1:
        p = dfs(tree_info, vec[node][0], depth + 1, p)
    p += 1
    try:
        tree_info[depth].append(p)
    except:
        tree_info[depth] = []
        tree_info[depth].append(p)
    if vec[node][1] != -1:
        p = dfs(tree_info, vec[node][1], depth + 1, p)
    return p


if __name__ == "__main__":
    N = int(input())
    vec = [[] for _ in range(N + 1)]
    uf = [-1] * (N + 1)
    tree_infos = [[] for _ in range(N + 1)]
    for i in range(N):
        a, b, c = map(int, input().split())
        vec[a].append(b)
        vec[a].append(c)
        if b != -1:
            merge(a, b)
        if c != -1:
            merge(a, c)
    root = []
    for i in range(1, N + 1):
        if uf[i] < 0:
            root.append(i)
            tree_infos[i].append(dict())
    for i in root:
        dfs(tree_infos[i][0], i, 1, 0)
    answer_key = math.inf
    answer = 0
    for i in root:
        tree_info = tree_infos[i][0]
        for key, value in tree_info.items():
            value.sort()
            temp = value[-1] - value[0] + 1
            if temp > answer:
                answer = temp
                answer_key = key
            elif temp == answer:
                if answer_key > key:
                    answer_key = key
    print(answer_key, answer)

