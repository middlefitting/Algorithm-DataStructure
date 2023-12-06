class Block:
    def __init__(self):
        self.N = int(input())
        self.arr = []
        for i in range(self.N):
            self.arr.append([])
            temp = list(map(int, input().split()))
            for j in temp:
                self.arr[i].append([j, 0])
        self.answer = 0
        self.mv = [[1, 0], [0, 1], [-1, 0], [0, -1]]

    def start(self):
        self.dfs(0, self.arr)

    def dfs(self, depth, arr):
        if depth >= 5:
            temp = 0
            for i in range(self.N):
                for j in range(self.N):
                    temp = max(arr[i][j][0], temp)
            self.answer = max(self.answer, temp)
            return
        for mx, my in self.mv:
            next = self.move(mx, my, arr)
            self.renew(next)
            self.dfs(depth + 1, next)

    def renew(self, arr):
        for i in range(self.N):
            for j in range(self.N):
                arr[i][j][1] = 0

    def move(self, mx, my, arr):
        next = self.copy_arr(arr)
        for i in range(self.N):
            for j in range(self.N):
                tx, ty = self.position(mx, my, i, j)
                if next[tx][ty][0] == 0:
                    continue
                v, flag = next[tx][ty]
                next[tx][ty] = [0, 0]
                self.logic(v, flag, mx, my, tx, ty, next)
        return next

    def copy_arr(self, arr):
        cp = []
        for i in range(self.N):
            cp.append([])
            for j in range(self.N):
                cp[i].append(arr[i][j].copy())
        return cp

    def position(self, mx, my, i, j):
        if mx == 1:
            return self.N - i - 1, j
        if mx == -1:
            return i, j
        if my == 1:
            return i, self.N - j - 1
        if my == -1:
            return j, i

    def logic(self, v, flag, mx, my, tx, ty, next):
        is_merge = False
        while True:
            tx, ty = tx + mx, ty + my
            if tx < 0 or tx >= self.N or ty < 0 or ty >= self.N:
                tx, ty = tx - mx, ty - my
                break
            if next[tx][ty][0] == 0:
                continue
            if next[tx][ty][0] == v and next[tx][ty][1] == 0 and flag == 0:
                is_merge = True
                next[tx][ty][0] = v * 2
                next[tx][ty][1] = 1
                break
            else:
                tx, ty = tx - mx, ty - my
                break
        if not is_merge:
            next[tx][ty][0] = v
            next[tx][ty][1] = flag
        return

    def get_answer(self):
        return self.answer


if __name__ == "__main__":
    block = Block()
    block.start()
    print(block.get_answer())

