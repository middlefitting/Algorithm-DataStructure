class UnionFind:
    def __init__(self):
        self.N, self.L, self.R = map(int, input().split())
        self.arr = [list(map(int, input().split())) for _ in range(self.N)]
        self.value = [0] * (self.N ** 2)
        self.uf = [-1] * (self.N ** 2)
        self.refresh_value()

    def find(self, a):
        if self.uf[a] < 0:
            return a
        self.uf[a] = self.find(self.uf[a])
        return self.find(self.uf[a])

    def merge(self, a, b):
        a = self.find(a)
        b = self.find(b)
        if a == b:
            return False
        self.uf[a] += self.uf[b]
        self.uf[b] = a
        self.value[a] += self.value[b]
        return True

    def refresh_arr(self):
        for i in range(self.N):
            for j in range(self.N):
                self.arr[i][j] = self.value[self.find(i * self.N + j)] // (-1 * self.uf[self.find(i * self.N + j)])

    def refresh_value(self):
        for i in range(self.N):
            for j in range(self.N):
                self.value[i * self.N + j] = self.arr[i][j]
                self.uf[i * self.N + j] = -1

    def moving(self):
        mv = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        answer = 0
        while True:
            flag = False
            for i in range(self.N):
                for j in range(self.N):
                    for mx, my in mv:
                        tx, ty = i + mx, j + my
                        if (not 0 <= tx < self.N) or (not 0 <= ty < self.N):
                            continue
                        if not self.L <= abs(self.arr[i][j] - self.arr[tx][ty]) <= self.R:
                            continue
                        if self.merge(i * self.N + j, tx * self.N + ty):
                            flag = True
            if not flag:
                return answer
            answer += 1
            self.refresh_arr()
            self.refresh_value()


if __name__ == "__main__":
    union_find = UnionFind()
    print(union_find.moving())