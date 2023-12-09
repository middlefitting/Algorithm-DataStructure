from collections import deque

N = int(input())
arr = [list(str(input())) for _ in range(N)]
num_arr = [[0] * N for _ in range(N)]
v = [[False] * N for _ in range(N)]
mv = [[-1, 0], [-1, 1], [0, 1], [0, -1], [1, -1], [1, 0]]
answer = 0


def impossible(temp, i, j):
    if i < 0 or i >= N or j >= N or j < 0:
        return False
    if num_arr[i][j] == temp:
        return True
    return False


if __name__ == "__main__":
    queue = deque([])
    for i in range(N):
        for j in range(N):
            if (not v[i][j]) and arr[i][j] == "X":
                v[i][j] = True
                queue.append([i, j])
                num_arr[i][j] = 1
                answer = max(answer, 1)
                while queue:
                    x, y = queue.popleft()
                    for mx, my in mv:
                        tx, ty = x + mx, y + my
                        if tx < 0 or ty < 0 or tx >= N or ty >= N:
                            continue
                        if arr[tx][ty] != "X":
                            continue
                        if v[tx][ty]:
                            continue
                        v[tx][ty] = True
                        queue.append([tx, ty])
                        temp = 1
                        while True:
                            flag = True
                            for nx, ny in mv:
                                if impossible(temp, nx + tx, ny + ty):
                                    flag = False
                                    break
                            if not flag:
                                temp += 1
                                continue
                            break
                        num_arr[tx][ty] = temp
                        if temp >= 3:
                            print(3)
                            exit()
                        answer = max(temp, answer)
    print(answer)


