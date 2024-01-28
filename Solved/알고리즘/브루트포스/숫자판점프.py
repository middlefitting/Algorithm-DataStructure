s = set()
arr = [list(map(str, input().split())) for _ in range(5)]
mv = [[1, 0], [0, 1], [-1, 0], [0, -1]]


def dfs(depth, i, j, result):
    if depth == 5:
        s.add(result)
        return
    for mx, my in mv:
        tx, ty = mx + i, my + j
        if 0 <= tx < 5 and 0 <= ty < 5:
            dfs(depth + 1, tx, ty, result + arr[tx][ty])


if __name__ == "__main__":
    for i in range(5):
        for j in range(5):
            dfs(0, i, j, arr[i][j])
    print(len(s))