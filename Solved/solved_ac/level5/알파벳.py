import sys

R, C = map(int, sys.stdin.readline().split())
arr = [[] for _ in range(R)]
for i in range(R):
    temp = list(map(str, sys.stdin.readline()))
    for j in range(C):
        arr[i].append(ord(temp[j]) - 65)

answer = [1]
index = [[-1, 0], [1, 0], [0, -1], [0, 1]]
alpha = [0] * 26


def dfs(i, j, depth):
    for ind in index:
        if (0 <= i + ind[0] < R) and (0 <= j + ind[1] < C):
            if not alpha[arr[i + ind[0]][j + ind[1]]]:
                alpha[arr[i + ind[0]][j + ind[1]]] = 1
                answer[0] = max(depth + 1, answer[0])
                dfs(i + ind[0], j + ind[1], depth + 1)
                alpha[arr[i + ind[0]][j + ind[1]]] = 0


alpha[arr[0][0]] = 1
dfs(0, 0, 1)
print(answer[0])
