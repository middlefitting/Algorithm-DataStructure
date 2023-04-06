import sys

# sysin = sys.stdin.readline()

if __name__ == "__main__":
    N, M, Q = map(int, sys.stdin.readline().split())
    arr = []
    pSum = [[0] * M for _ in range(N)]
    for i in range(N):
        arr.append(list(map(int, sys.stdin.readline().split())))
    for i in range(N):
        pSum[i][0] = arr[i][0]
    for i in range(N):
        for j in range(1, M):
            pSum[i][j] = pSum[i][j - 1]
            pSum[i][j] += arr[i][j]
    for _ in range(Q):
        temp = 0
        r1, c1, r2, c2 = map(int, sys.stdin.readline().split())
        r1, c1, r2, c2 = r1 - 1, c1 - 1, r2 - 1, c2 - 1
        for i in range(r1, r2 + 1):
            temp += pSum[i][c2]
            if c1 != 0:
                temp -= pSum[i][c1 - 1]
        temp //= (c2 + 1 - c1) * (r2 + 1 - r1)
        print(temp)
