class Solution:
    def __init__(self, arr):
        self.arr = [[0] * 100 for _ in range(100)]
        self.r_size = 3
        self.c_size = 0
        for i in range(3):
            self.c_size = max(self.c_size, len(arr[i]))
            self.c_size = min(self.c_size, 100)
            for j in range(min(len(arr[i]), 100)):
                self.arr[i][j] = arr[i][j]

    def new_arr(self, pre):
        d = dict()
        arr = []
        for i in pre:
            if i == 0:
                continue
            try:
                d[i] += 1
            except:
                d[i] = 1
                continue
        for key, value in d.items():
            arr.append([key, value])
        arr.sort(key=lambda x: (x[1], x[0]))
        next = []
        for i in range(len(arr)):
            if len(next) == 100:
                break
            next.append(arr[i][0])
            next.append(arr[i][1])
        return next

    def row_sort(self):
        next_size = 0
        for i in range(self.r_size):
            new = self.new_arr(arr[i])
            next_size = max(len(new), next_size)
            self.arr[i] = [0] * 100
            for j in range(min(len(new), 100)):
                self.arr[i][j] = new[j]
        self.c_size = next_size

    def col_sort(self):
        next_size = 0
        for i in range(self.c_size):
            temp = []
            for j in range(100):
                temp.append(arr[j][i])
            new = self.new_arr(temp)
            next_size = max(len(new), next_size)
            for j in range(100):
                self.arr[j][i] = 0
            for j in range(min(len(new), 100)):
                self.arr[j][i] = new[j]
        self.r_size = next_size

    def logic(self):
        if self.r_size >= self.c_size:
            self.row_sort()
        else:
            self.col_sort()
        return self.arr


if __name__ == "__main__":
    r, c, k = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(3)]
    solution = Solution(arr)
    if r <= 3 and c <= len(arr[0]) and arr[r - 1][c - 1] == k:
        print(0)
        exit(0)
    for i in range(1, 101):
        arr = solution.logic()
        if r <= 3 and c <= len(arr[0]) and arr[r - 1][c - 1] == k:
            print(i)
            exit(0)
    print(-1)
