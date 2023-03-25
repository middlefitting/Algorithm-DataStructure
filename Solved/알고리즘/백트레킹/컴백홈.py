def back_tracking(x, y, depth):
    if x == 0 and y == M - 1:
        if depth == K:
            answer[0] += 1
        return
    for mx, my in mv:
        tx, ty = mx + x, my + y
        if 0 <= tx < N and 0 <= ty < M:
            if (arr[tx][ty] != '1') and (arr[tx][ty] != 'T'):
                arr[tx][ty] = '1'
                back_tracking(tx, ty, depth + 1)
                arr[tx][ty] = '.'


if __name__ == "__main__":
    N, M, K = map(int, input().split())
    mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    answer = [0]
    arr = []
    for _ in range(N):
        arr.append(list(str(input())))
    arr[N - 1][0] = '1'
    back_tracking(N - 1, 0, 1)
    print(answer[0])
