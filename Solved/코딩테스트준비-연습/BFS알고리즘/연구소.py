from collections import deque

N, M = map(int, input().split())
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
queue = deque([])
arr = []
answer = [0]
for _ in range(N):
    arr.append(list(map(int, input().split())))


def dfs(depth):
    if depth == 3:
        for i in range(N):
            for j in range(M):
                if arr[i][j] == 2:
                    queue.append([i, j])
        temp = []
        for i in range(N):
            temp.append(arr[i].copy())
        while queue:
            x = queue.popleft()
            for [dx, dy] in mv:
                y = [x[0] + dx, x[1] + dy]
                if 0 <= y[0] < N and 0 <= y[1] < M:
                    if temp[y[0]][y[1]] == 0:
                        temp[y[0]][y[1]] = 2
                        queue.append(y)
        t_answer = 0
        for i in range(N):
            for j in range(M):
                if temp[i][j] == 0:
                    t_answer += 1
        answer[0] = max(answer[0], t_answer)
        return

    for i in range(N):
        for j in range(M):
            if arr[i][j] == 0:
                arr[i][j] = 1
                dfs(depth + 1)
                arr[i][j] = 0


dfs(0)
print(answer[0])
