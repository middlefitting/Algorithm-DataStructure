import sys
sys.setrecursionlimit(10**6)


def dfs(x):
    for i in vec[x]:
        dfs(i)
    if x == 1:
        return

    if arr[x][0] > 0:
        arr[arr[x][1]][0] += arr[x][0]
        arr[x][0] = 0


if __name__ == "__main__":
    arr = [[], [0, 0]]
    N = int(sys.stdin.readline())
    vec = [[] for _ in range(N + 1)]
    for i in range(N - 1):
        ti, ai, pi = map(str, sys.stdin.readline().split())
        if ti == 'S':
            arr.append([int(ai), int(pi)])
        else:
            arr.append([int(ai) * -1, int(pi)])
        vec[int(pi)].append(i + 2)
    dfs(1)
    print(arr[1][0])
