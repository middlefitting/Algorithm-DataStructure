import math

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
cctvs = []
for i in range(N):
    for j in range(M):
        if 0 < arr[i][j] < 6:
            cctvs.append([i, j])
answer = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == 0:
            answer += 1

positions = [
    [],
    [ [[1, 0]], [[-1, 0]], [[0, 1]], [[0, -1]] ],
    [ [[1, 0], [-1, 0]], [[0, 1], [0, -1]] ],
    [ [[1, 0], [0, -1]], [[1, 0], [0, 1]], [[-1, 0], [0, -1]], [[-1, 0], [0, 1]] ],
    [ [[1, 0], [0, -1], [-1, 0]], [[0, -1], [-1, 0], [0, 1]], [[-1, 0], [0, 1], [1, 0]], [[0, 1], [1, 0], [0, -1]] ],
    [ [[1, 0], [0, 1], [-1, 0], [0, -1]] ]
]


def dfs(depth, result):
    global answer
    global arr
    if depth == len(cctvs):
        answer = min(result, answer)
        return

    cctv = cctvs[depth]
    position = positions[arr[cctv[0]][cctv[1]]]
    for i in range(len(position)):
        select = position[i]
        next_result = result
        mark = []
        for mx, my in select:
            tx, ty = cctv[0], cctv[1]
            while 0 <= tx < N and 0 <= ty < M and arr[tx][ty] != 6:
                if arr[tx][ty] == 0:
                    arr[tx][ty] = -1
                    next_result -= 1
                    mark.append([tx, ty])
                tx += mx
                ty += my
        dfs(depth + 1, next_result)
        for x, y in mark:
            arr[x][y] = 0


if __name__ == "__main__":
    dfs(0, answer)
    print(answer)
