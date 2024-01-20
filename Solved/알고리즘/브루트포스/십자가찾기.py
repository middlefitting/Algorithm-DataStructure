import sys

sin = sys.stdin.readline


class Ten:
    def __init__(self, arr, n, m):
        self.arr = arr
        self.N = n
        self.M = m

    def find_(self):
        answer = []
        cnt_arr = [[0] * self.M for _ in range(self.N)]
        for i in range(self.N):
            for j in range(self.M):
                if self.arr[i][j] == "*":
                    cnt = 0
                    x, y = i, j
                    idx = 1
                    while True:
                        if 0 <= x + idx < self.N and 0 <= x - idx < self.N and 0 <= y + idx < self.M and 0 <= y - idx < self.M:
                            if self.arr[x + idx][y] == "*" and self.arr[x][y + idx] == "*" and self.arr[x - idx][y] == "*" and self.arr[x][y - idx] == "*":
                                if cnt_arr[x + idx][y] == 0:
                                    cnt_arr[x + idx][y] += 1
                                    cnt += 1
                                if cnt_arr[x - idx][y] == 0:
                                    cnt_arr[x - idx][y] += 1
                                    cnt += 1
                                if cnt_arr[x][y + idx] == 0:
                                    cnt_arr[x][y + idx] += 1
                                    cnt += 1
                                if cnt_arr[x][y - idx] == 0:
                                    cnt_arr[x][y - idx] += 1
                                    cnt += 1
                                idx += 1
                                continue
                        break
                    if idx > 1 and cnt > 0:
                        if cnt_arr[i][j] == 0:
                            cnt_arr[i][j] += 1
                            cnt += 1
                        answer.append([x + 1, y + 1, idx - 1])
        flag = True
        for i in range(self.N):
            for j in range(self.M):
                if self.arr[i][j] == "*" and cnt_arr[i][j] == 0:
                    flag = False
        if not flag:
            return -1
        return answer


if __name__ == "__main__":
    N, M = map(int, input().split())
    arr = [str(input()) for _ in range(N)]
    ten = Ten(arr, N, M )
    result = ten.find_()
    if result == -1:
        print(-1)
    else:
        print(len(result))
        for temp in result:
            for j in temp:
                print(j, end=" ")
            print("")