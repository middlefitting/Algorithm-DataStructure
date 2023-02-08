mv = [[1, 0], [0 ,1]]
find_answer = [0]
v = []
arr = [[0] * 9 for _ in range(9)]
ind = 0
C = [[0] * 10 for _ in range(10)]
R = [[0] * 10 for _ in range(10)]
B = [[0] * 10 for _ in range(10)]


def find_direction(d):
    return [ord(d[0]) - 65, int(d[1]) - 1]


def possible_game(x, y, n):
    if R[x][n] != 0:
        return False
    if C[y][n] != 0:
        return False
    dx = (x // 3) * 3
    dy = (y // 3)
    if B[dx + dy][n] != 0:
        return False
    return True


def dfs_logic(i, j, x, y, tx, ty, depth):
    if possible_game(x, y, i) and possible_game(tx, ty, j):
        arr[x][y] = i
        arr[tx][ty] = j
        v[i][j] = 1
        v[j][i] = 1
        R[x][i] = 1
        R[tx][j] = 1
        C[y][i] = 1
        C[ty][j] = 1
        dx = (x // 3) * 3
        dy = (y // 3)
        B[dx + dy][i] = 1
        dx = (tx // 3) * 3
        dy = (ty // 3)
        B[dx + dy][j] = 1
        dfs(depth + 1)
        arr[x][y] = 0
        arr[tx][ty] = 0
        v[i][j] = 0
        v[j][i] = 0
        R[x][i] = 0
        R[tx][j] = 0
        C[y][i] = 0
        C[ty][j] = 0
        dx = (x // 3) * 3
        dy = (y // 3)
        B[dx + dy][i] = 0
        dx = (tx // 3) * 3
        dy = (ty // 3)
        B[dx + dy][j] = 0


def print_arr():
    for i in range(9):
        for j in range(9):
            print(arr[i][j], end="")
        print()


def dfs(depth):
    if find_answer[0] == 1:
        return
    if depth == 81:
        find_answer[0] = 1
        print_arr()
        return
    x = depth // 9
    y = depth % 9
    if arr[x][y] != 0:
        dfs(depth + 1)
        return
    for mx, my in mv:
        tx, ty = x + mx, y + my
        if tx >= 9 or ty >= 9:
            continue
        if arr[tx][ty] != 0:
            continue
        for i in range(1, 10):
            for j in range(i + 1, 10):
                if v[i][j] != 0:
                    continue
                dfs_logic(i, j, x, y, tx, ty, depth)
                dfs_logic(j, i, x, y, tx, ty, depth)


while True:
    ind += 1
    N = int(input())
    if N == 0:
        break
    print("Puzzle", ind)
    arr = [[0] * 9 for _ in range(9)]
    find_answer[0] = 0
    v = [[0] * 10 for _ in range(10)]
    C = [[0] * 10 for _ in range(10)]
    R = [[0] * 10 for _ in range(10)]
    B = [[0] * 10 for _ in range(10)]
    for _ in range(N):
        n1, d1, n2, d2 = map(str, input().split())
        n1 = int(n1)
        n2 = int(n2)
        dx1, dy1 = find_direction(d1)
        dx2, dy2 = find_direction(d2)
        arr[dx1][dy1] = n1
        arr[dx2][dy2] = n2
        v[n1][n2] = 1
        v[n2][n1] = 1
        R[dx1][n1] = 1
        R[dx2][n2] = 1
        C[dy1][n1] = 1
        C[dy2][n2] = 1
        dx = (dx1 // 3) * 3
        dy = (dy1 // 3)
        B[dx + dy][n1] = 1
        dx = (dx2 // 3) * 3
        dy = (dy2 // 3)
        B[dx + dy][n2] = 1
    temp = list(map(str, input().split()))
    for i in range(9):
        tx, ty = find_direction(temp[i])
        arr[tx][ty] = i + 1
        R[tx][i + 1] = 1
        C[ty][i + 1] = 1
        dx = (tx // 3) * 3
        dy = (ty // 3)
        B[dx + dy][i + 1] = 1
    dfs(0)




